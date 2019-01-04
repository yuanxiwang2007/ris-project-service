package com.rms.risproject.mapper;

import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MongodbDao<T> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveObjectValue(T obj) {
        mongoTemplate.save(obj);
    }

    public void updateObjectValueByPramarykey(T obj) throws NoSuchFieldException, IllegalAccessException {
        Field field = getDeclaredField(obj, "keyId");
        field.setAccessible(true);
        Object value = field.get(obj);
        Query query = new Query(Criteria.where("keyId").is(value));
        Update update = new Update();
        update.set("name", 1);
        update.set("phoneNo", "123123123");
        mongoTemplate.updateFirst(query, update, obj.getClass());
    }

    /**
     * @desc
     */
    public void queryMachineScanRecordInfo(Date beginDate, Date endDate, String collectionName) {
        //MachineScanRecordInfoVo infoVo
        //mongoTemplate.save(infoVo,"MachineScanRecordInfo");
        List<DBObject> aggregateQuery = new ArrayList<DBObject>();
        BasicDBObject groupHeapNum = new BasicDBObject();
        BasicDBObjectBuilder yearBuilder = new BasicDBObjectBuilder();
        BasicDBObjectBuilder monthBuilder = new BasicDBObjectBuilder();
        BasicDBObjectBuilder dayBuilder = new BasicDBObjectBuilder();

        BasicDBList dateList = new BasicDBList();
        dateList.add("$addTime");
        dateList.add(28800000);
        DBObject time = new BasicDBObject("$add", dateList);


        //phoneBuilder.add("$add","[\"$addTime\",28800000]");

        yearBuilder.add("$year", time);
        monthBuilder.add("$month", time);
        dayBuilder.add("$dayOfMonth", time);
        groupHeapNum.append("year", yearBuilder.get());
        groupHeapNum.append("month", monthBuilder.get());
        groupHeapNum.append("day", dayBuilder.get());
        groupHeapNum.append("machineID", "$machineID");
        groupHeapNum.append("openID", "$openID");
        groupHeapNum.append("phone", "$phone");
        BasicDBObjectBuilder groupBuilder = new BasicDBObjectBuilder();
        groupBuilder.add("_id", groupHeapNum);
        groupBuilder.add("buildingName", new BasicDBObject("$max", "$machineInfoVo.buildingName"));
        groupBuilder.add("count", new BasicDBObject("$sum", 1));
//获取组内发布时间最新的数据
        //groupBuilder.add("publishDate", new BasicDBObject("$max", "$publishDate"));
//获取组内发布时间最新的数据
        //groupBuilder.add("heapNum", new BasicDBObject("$first", "$heapNum"));
        //groupBuilder.add("count", new BasicDBObject("$sum", 1));
// 分組 每组的重复次数


//分组后 总数大于1的，且含查询条件
        BasicDBObjectBuilder matchBuilder = new BasicDBObjectBuilder();
        //matchBuilder.add("count", new BasicDBObject("$gt", 1));
        if (beginDate != null && endDate != null) {
            BasicDBObjectBuilder publishDateBuilder = new BasicDBObjectBuilder();
            publishDateBuilder.add("$gte", beginDate);
            publishDateBuilder.add("$lt", endDate);
            matchBuilder.add("addTime", publishDateBuilder.get());
        }
        aggregateQuery.add(new BasicDBObject("$match", matchBuilder.get()));
        aggregateQuery.add(new BasicDBObject("$group", groupBuilder.get()));
        aggregateQuery.add(new BasicDBObject("$sort", new BasicDBObject("_id", -1)));//排序
        BasicDBObjectBuilder countGroupBuilder = new BasicDBObjectBuilder();
        countGroupBuilder.add("_id", null);
        countGroupBuilder.add("sum", new BasicDBObject("$sum", 1));
        aggregateQuery.add(new BasicDBObject("$group", countGroupBuilder.get()));
        //aggregateQuery.add(new BasicDBObject("$skip", pageSize * (currentPage - 1)));
        //aggregateQuery.add(new BasicDBObject("$limit", pageSize));

        AggregationOptions aggregationOptions = AggregationOptions.builder().allowDiskUse(true).build();

        DBCollection collection = mongoTemplate.getDb().getCollection("MachineScanRecordInfo");
        Cursor cursor = collection.aggregate(aggregateQuery, aggregationOptions);
        while (cursor.hasNext()) {//查出分组条数
            DBObject next = cursor.next();
            Object _id = next.get("_id");
            String id = "";
            if (_id != null) {
                id = _id.toString();
            }
            String count = next.get("sum").toString();
            System.out.println(id + ":" + count);
        }


//        List<DBObject> countQuery = new ArrayList<DBObject>(aggregateQuery);
//        BasicDBObjectBuilder countGropuBuilder = new BasicDBObjectBuilder();
//        countGropuBuilder.add("_id", null);
//        countGropuBuilder.add("sum", new BasicDBObject("$sum",1));
//        countQuery.add(new BasicDBObject("$group",countGropuBuilder.get()));// 分組 每组的重复次数
//        Cursor cursor = collection.aggregate(aggregateQuery, aggregationOptions);
//        while (cursor.hasNext()) {//查出每个的信息
//            DBObject next = cursor.next();
//            String heapNum = next.get("heapNum").toString();
//        }
    }


    public List<T> getObjectValue(Class<T> classs) {
        Query query = new Query();
        Criteria criteria = Criteria.where("isDeleted").is(0);
        query.addCriteria(criteria);
        List<T> list = mongoTemplate.find(query, classs);
        return list;
    }

    private Field getDeclaredField(Object object, String fieldName) {
        Field field = null;

        Class<?> clazz = object.getClass();

        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (NoSuchFieldException e) {
                logger.debug("无此字段:{}", e.getMessage());
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return null;
    }
}

# 数据表说明文档

- 注意：所有时间相关的字段均为UNIX时间戳。

------

## student

用于存储学生相关信息。

| 字段         | 类型        | 说明         | 是否必须 | 备注                        |
| ------------ | ----------- | ------------ | -------- | --------------------------- |
| stu_id       | VARCHAR(10) | 学生编号     | 是       | 主键，自增，格式：'S' + num |
| stu_username | VARCHAR(20) | 用户名       | 是       | 唯一                        |
| stu_password | CHAR(32)    | 密码         | 是       | 密码加盐之后的MD5值         |
| stu_realname | VARCHAR(20) | 学生姓名     | 是       |                             |
| stu_class    | INTEGER     | 学生所在班级 | 是       | 表class的外键               |
| stu_gender   | INTEGER     | 学生性别     | 是       | {0: 'male', 1: 'female'}    |

------

## teacher

用于存储教师相关信息。

| 字段         | 类型        | 说明     | 是否必须 | 备注                        |
| ------------ | ----------- | -------- | -------- | --------------------------- |
| tch_id       | VARCHAR(10) | 教师编号 | 是       | 主键，自增，格式：'T' + num |
| tch_username | VARCHAR(20) | 用户名   | 是       | 唯一                        |
| tch_password | CHAR(32)    | 密码     | 是       | 密码加盐之后的MD5值         |
| tch_realname | VARCHAR(20) | 教师姓名 | 是       |                             |
| tch_gender   | INTEGER     | 教师性别 | 是       | {0: 'male', 1: 'female'}    |

------

## class

用于存储班级相关信息。

| 字段       | 类型        | 说明         | 是否必须 | 备注                        |
| ---------- | ----------- | ------------ | -------- | --------------------------- |
| class_id   | VARCHAR(10) | 班级编号     | 是       | 主键，自增，格式：'C' + num |
| class_name | VARCHAR(20) | 班级名称     | 是       | 唯一                        |
| tch_id     | VARCHAR(10) | 班级所属教师 | 是       | 表teacher的外键             |

------

## question（total）

用于存储试题相关信息。

| 字段   | 类型        | 说明     | 是否必须 | 备注                                                         |
| ------ | ----------- | -------- | -------- | ------------------------------------------------------------ |
| q_id   | VARCHAR(10) | 试题编号 | 是       | 主键，自增，格式：'Q' + num                                  |
| q_type | ENUM        | 试题类型 | 是       | {0: '单选题', 1: '多选题', 2: '判断题', 3: '填空题', 4: '主观题'} |

------

## question(choice)

| 字段       | 类型         | 说明     | 是否必须 | 备注                           |
| ---------- | ------------ | -------- | -------- | ------------------------------ |
| q_id       | VARCHAR(10)  | 试题编号 | 是       | 主键,外键 REFERENCE FROM TOTAL |
| q_title    | VARCHAR(255) | 试题题目 | 是       | UNIQUE                         |
| q_opMethod | JSON         | 选项内容 | 是       | UNIQUE                         |
| q_opRight  | VARCHAR(255) | 正确选项 | 是       | 均为字符串                     |
| q_sore     | INTEGER      | 分值     | 是       |                                |

## question(blank)

| 字段      | 类型         | 说明     | 是否必须 | 备注                           |
| --------- | ------------ | -------- | -------- | ------------------------------ |
| q_id      | VARCHAR(10)  | 试题编号 | 是       | 主键,外键 REFERENCE FROM TOTAL |
| q_title   | VARCHAR(255) | 试题题目 | 是       | UNIQUE                         |
| q_opRight | VARCAHR(255) | 正确答案 | 是       | 填空题:string                  |
| q_score   | INTEGER      | 分值     | 是       |                                |

## question(judge)

| 字段      | 类型         | 说明     | 是否必须 | 备注                           |
| --------- | ------------ | -------- | -------- | ------------------------------ |
| q_id      | VARCHAR(10)  | 试题编号 | 是       | 主键,外键 REFERENCE FROM TOTAL |
| q_title   | VARCHAR(255) | 试题题目 | 是       | UNIQUE                         |
| q_opRight | VARCAHR(255) | 正确答案 | 是       | 判断题(T/F):string             |
| q_score   | INTEGER      | 分值     | 是       |                                |

## question(sub)

| 字段    | 类型         | 说明     | 是否必须 | 备注                           |
| ------- | ------------ | -------- | -------- | ------------------------------ |
| q_id    | VARCHAR(10)  | 试题编号 | 是       | 主键,外键 REFERENCE FROM TOTAL |
| q_title | VARCHAR(255) | 试题题目 | 是       | UNIQUE                         |
| q_pic   | BLOB         | 试题配图 | 否       | MEDIUMBLOB                     |
| q_score | INTEGER      | 分值     | 是       |                                |

## quiz_ans

| 字段        | 类型         | 说明         | 是否必须 | 备注 |
| ----------- | ------------ | ------------ | -------- | ---- |
| QuizAns_id  | VARCHAR(10)  | 答题编号     | 是       | 主键 |
| QuizRec_id  | VARCHAR(10)  | 考试记录编号 | 是       | 外键 |
| Q_id        | VARCHAR(10)  | 试题编号     | 是       | 外键 |
| qa_ans      | VARCHAR(255) | 学生答题内容 | 否       |      |
| qa_GetScore | INTEGER      | 得分         | 是       |      |

## exampaper

用于存储试卷相关信息。

| 字段     | 类型         | 说明     | 是否必须 | 备注                        |
| -------- | ------------ | -------- | -------- | --------------------------- |
| ep_id    | VARCHAR(10)  | 试卷编号 | 是       | 主键，自增，格式：'P' + num |
| ep_title | VARCHAR(255) | 试卷名称 | 是       |                             |
| ep_score | INTEGER      | 试卷总分 | 否       |                             |

------

## exam

用于存储考试相关信息。

| 字段           | 类型          | 说明         | 是否必须 | 备注                        |
| -------------- | ------------- | ------------ | -------- | --------------------------- |
| exam_id        | VARCHAR(10)   | 考试编号     | 是       | 主键，自增，格式：'E' + num |
| exam_title     | VARCHAR(255)  | 考试名称     | 是       |                             |
| ep_id          | VARCHAR(10)   | 对应试卷编号 | 是       | 表exampaper的外键           |
| exam_begintime | TIMESTAMP(14) | 考试开始时间 | 是       |                             |
| exam_endtime   | TIMESTAMP(14) | 考试结束时间 | 是       |                             |

------

## ep_qu

用于存储试卷和试题的对应关系。

| 字段  | 类型        | 说明     | 是否必须 | 备注                    |
| ----- | ----------- | -------- | -------- | ----------------------- |
| ep_id | VARCHAR(10) | 试卷编号 | 是       | 主键，表exampaper的外键 |
| qu_id | VARCHAR(10) | 试题编号 | 是       | 主键，表question的外键  |

------

## exam_record

用于存储考试记录（除主观题外）相关信息。

| 字段          | 类型         | 说明           | 是否必须 | 备注                        |
| ------------- | ------------ | -------------- | -------- | --------------------------- |
| QuizRec_id    | VARCHAR(10)  | 考试记录编号   | 是       | 主键，自增，格式：'R' + num |
| QuizRec_title | VARCHAR(255) | 考试名称       | 是       |                             |
| stu_id        | VARCHAR(10)  | 作答的学生编号 | 是       | 表student的外键             |
| ep_id         | VARCHAR(10)  | 对应试卷编号   | 是       | 表exampaper的外键           |
| ans_rec       | TEXT         | 答题记录       | 是       | quiz_ans以“，”分隔          |
| total_score   | INTEGER      | 考试得分       | 是       |                             |



## Wrong_collection

| 字段      | 类型        | 说明       | 是否必须 | 备注 |
| --------- | ----------- | ---------- | -------- | ---- |
| wc_id     | VARCHAR(10) | 错题集编号 | 是       | 主键 |
| stu_id    | VARCHAR(10) | 学生编号   | 是       | 外键 |
| wrong_ans | JSON        | 错题集内容 | 是       |      |

```json
//eg：wrong_ans "qa_id":"cnt_wrong" "答题编号":错误次数
{
    "121":"2",
    "122":"3"
}
```


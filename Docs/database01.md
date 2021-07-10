# ExamOnline数据库设计

------



## 数据表清单

SAQ:short answer question  简答题

方便查询 用户登陆信息（用户登陆账号  密码 放在各个角色类里）

| **数据库名称**  | **ExamOnline**                    |
| --------------- | --------------------------------- |
| **开发环境**    | **MySQL**                         |
| **表名**        | **说明**                          |
| Student         | 学生                              |
| Teacher         | 教师                              |
| Admin           | 管理员                            |
| ExamManage      | 考试管理  安排考试等              |
| PaperManage     | 试卷管理                          |
| Single          | 单选题                            |
| Multiple        | 多选题                            |
| Judge           | 判断题                            |
| Fill            | 填空题                            |
| SAQ             | 简答题                            |
| SubjectInfo     | 课程信息                          |
| StudentPaper    | 学生答卷                          |
| PaperResult     | 教师批阅结果  含各题目成绩        |
| StudentExam     | 学生考试信息 已参加未参加  总成绩 |
| News            | 公告、通知                        |
| Message         | 学生留言、提问                    |
| Replay          | 教师答复                          |
| AuthorityManage | 权限管理                          |
| Spare           | 备用                              |

------

## Student

| 字段        | 类型    | 位数 | 说明     | 备注                   |
| ----------- | ------- | ---- | -------- | ---------------------- |
| S_id        | varchar | 20   | 学号     | 主键                   |
| S_name      | varchar | 20   | 学生姓名 | NOT NULL               |
| S_grade     | varchar | 20   | 年级     | NOT NULL               |
| S_major     | varchar | 50   | 专业     | NOT NULL               |
| S_class     | varchar | 20   | 班级     | NOT NULL               |
| S_institute | varchar | 20   | 学院     | NOT NULL               |
| S_tel       | varchar | 11   | 学生电话 | NOT NULL               |
| S_email     | varchar | 30   | 学生邮箱 | NOT NULL               |
| S_password  | varchar | 16   | 学生密码 | NOT NULL               |
| S_idcard    | varchar | 18   | 身份证号 | NOT NULL               |
| S_sex       | varchar | 2    | 性别     | 约束（男，女）NOT NULL |
| Spare       |         |      | 备用     |                        |

------

## Teacher

| 字段        | 类型    | 位数 | 说明     | 备注                   |
| ----------- | ------- | ---- | -------- | ---------------------- |
| T_id        | varchar | 20   | 教师工号 | 主键                   |
| T_name      | varchar | 20   | 教师姓名 | NOT NULL               |
| T_major     | varchar | 50   | 专业     | NOT NULL               |
| T_institute | varchar | 20   | 学院     | NOT NULL               |
| T_sex       | varchar | 2    | 性别     | 约束（男，女）NOT NULL |
| T_age       | varchar | 3    | 年龄     | NOT NULL               |
| T_tel       | varchar | 11   | 教师电话 | NOT NULL               |
| T_email     | varchar | 30   | 教师邮箱 | NOT NULL               |
| T_password  | varchar | 16   | 教师密码 | NOT NULL               |
| T_idcard    | varchar | 18   | 身份证号 | NOT NULL               |
| T_title     | varchar | 15   | 职称     | NOT NULL               |
| T_resume    | varchar | 255  | 简单履历 | NOT NULL               |
| Spare       |         |      | 备用     |                        |

------

## Admin

| 字段       | 类型    | 位数 | 说明       | 备注                                                      |
| ---------- | ------- | ---- | ---------- | --------------------------------------------------------- |
| A_id       | varchar | 20   | 管理员工号 | 主键                                                      |
| A_name     | varchar | 20   | 管理员姓名 | NOT NULL                                                  |
| A_sex      | varchar | 2    | 性别       | 约束（男，女）NOT NULL                                    |
| A_age      | varchar | 3    | 年龄       | NOT NULL                                                  |
| A_tel      | varchar | 11   | 管理员电话 | NOT NULL                                                  |
| A_email    | varchar | 20   | 管理员邮箱 | NOT NULL                                                  |
| A_password | varchar | 16   | 管理员密码 | NOT NULL                                                  |
| A_idcard   | varchar | 18   | 身份证号   | NOT NULL                                                  |
| A_level    | varchar | 1    | 级别       | 普通管理员不能添加新的管理员 系统管理员可以添加新的管理员 |
| Spare      |         |      | 备用       |                                                           |

------

## ExamManage

排考

| 字段        | 类型    | 位数 | 说明         | 备注               |
| ----------- | ------- | ---- | ------------ | ------------------ |
| Exam_id     | varchar | 20   | 考试编号     | 主键               |
| Exam_name   | varchar | 50   | 考试名称     |                    |
| Paper_type  | varchar | 2    | 试卷类型     | AB卷               |
| Source_id   | varchar | 10   | 课程信息     | 考试科目等信息     |
| Paper_id    | varchar | 10   | 试卷编号     |                    |
| Total_score | int     | 3    | 试卷总分     | 符合试卷组题       |
| StartTime   | date    |      | 开始时间     | 可以进入考试的时间 |
| EndTime     | date    |      | 结束时间     | 考试结束的时间     |
| ExamTime    | int     | 4    | 持续时间     |                    |
| Grade       | varchar | 20   | 年级         |                    |
| Term        | varchar | 20   | 学期         |                    |
| Major       | varchar | 50   | 专业         |                    |
| Institute   | varchar | 20   | 学院         |                    |
| T_id        | varchar | 20   | 出题教师id   |                    |
| A_id        | varchar | 20   | 监控管理员id |                    |
| Spare       |         |      | 备用         |                    |

------

## PaperManage

所有题目的难度加起来计算试卷难度  难度在某个区间设置种难度级别

| 字段           | 类型    | 位数 | 说明         | 备注         |
| -------------- | ------- | ---- | ------------ | ------------ |
| Paper_id       | varchar | 10   | 试卷编号     | 主键         |
| Source_id      | varchar | 10   | 课程信息     |              |
| Question_type  | varchar | 2    | 试题类型     | 约束（）     |
| ExanQu_num     | varchar | 2    | 试卷题目编号 | 1~xx         |
| Question_id    | varchar | 10   | 试题编号     | 题库中的编号 |
| Question_mark  | varchar | 3    | 试题分数     |              |
| Question_level | varchar | 2    | 试题难度     | 约束（1~5）  |
| Spare          |         |      | 备用         |              |

------

## Single

单选题库

| 字段             | 类型    | 位数 | 说明         | 备注         |
| ---------------- | ------- | ---- | ------------ | ------------ |
| Question_id      | varchar | 10   | 试题编号     | 主键 自增    |
| Question_type    | varchar | 2    | 试题类型     | 主键 约束    |
| Source_id        | varchar | 10   | 考试课程信息 |              |
| T_id             | varchar | 20   | 出题人       |              |
| Question_content | varchar | 255  | 题目内容     |              |
| OpA              | varchar | 255  | 选项A        |              |
| OpB              | varchar | 255  | 选项B        |              |
| OpC              | varchar | 255  | 选项C        |              |
| OpD              | varchar | 255  | 选项D        |              |
| Question_answer  | varchar | 2    | 正确答案     | 约束（ABCD） |
| Question_level   | varchar | 2    | 难度等级     | 约束（1~5）  |
| Knowledge_point  | varchar | 255  | 考察知识点   | 可以为空     |
| Spare            |         |      | 备用         |              |

------



## Multiple

多选题题库

| 字段             | 类型    | 位数 | 说明         | 备注                 |
| ---------------- | ------- | ---- | ------------ | -------------------- |
| Question_id      | varchar | 10   | 试题编号     | 主键 自增            |
| Question_type    | varchar | 2    | 试题类型     | 主键 约束            |
| Source_id        | varchar | 10   | 考试课程信息 |                      |
| T_id             | varchar | 20   | 出题人       |                      |
| Question_content | varchar | 255  | 题目内容     |                      |
| OpA              | varchar | 255  | 选项A        |                      |
| OpB              | varchar | 255  | 选项B        |                      |
| OpC              | varchar | 255  | 选项C        |                      |
| OpD              | varchar | 255  | 选项D        |                      |
| Question_answer  | varchar | 2    | 正确答案     | 约束（ABCD 中2~4个） |
| Question_level   | varchar | 2    | 难度等级     | 约束（1~5）          |
| Knowledge_point  | varchar | 255  | 考察知识点   | 可以为空             |
| Spare            |         |      | 备用         |                      |

------

## Judge

判断题

| 字段             | 类型    | 位数 | 说明         | 备注         |
| ---------------- | ------- | ---- | ------------ | ------------ |
| Question_id      | varchar | 10   | 试题编号     | 主键 自增    |
| Question_type    | varchar | 2    | 试题类型     | 主键 约束    |
| Source_id        | varchar | 10   | 考试课程信息 |              |
| T_id             | varchar | 20   | 出题人       |              |
| Question_content | varchar | 255  | 题目内容     |              |
| Question_answer  | varchar | 2    | 正确答案     | 约束（T，F） |
| Question_level   | varchar | 2    | 难度等级     | 约束（1~5）  |
| Knowledge_point  | varchar | 255  | 考察知识点   | 可以为空     |
| Spare            |         |      | 备用         |              |

------



## Fill

填空题

| 字段             | 类型    | 位数 | 说明         | 备注        |
| ---------------- | ------- | ---- | ------------ | ----------- |
| Question_id      | varchar | 10   | 试题编号     | 主键 自增   |
| Question_type    | varchar | 2    | 试题类型     | 主键 约束   |
| Source_id        | varchar | 10   | 考试课程信息 |             |
| T_id             | varchar | 20   | 出题人       |             |
| Question_content | varchar | 255  | 题目内容     |             |
| Question_answer  | varchar | 255  | 正确答案     |             |
| Question_level   | varchar | 2    | 难度等级     | 约束（1~5） |
| Knowledge_point  | varchar | 255  | 考察知识点   | 可以为空    |
| Spare            |         |      | 备用         |             |

------

## SAQ

简答题

| 字段             | 类型    | 位数 | 说明                 | 备注        |
| ---------------- | ------- | ---- | -------------------- | ----------- |
| Question_id      | varchar | 10   | 试题编号             | 主键 自增   |
| Question_type    | varchar | 2    | 试题类型             | 主键 约束   |
| Source_id        | varchar | 10   | 考试课程信息         |             |
| T_id             | varchar | 20   | 出题人               |             |
| Question_content | varchar | 255  | 题目内容             |             |
| Question_answer  | varchar | 2    | 正确答案             |             |
| Question_level   | varchar | 2    | 难度等级             | 约束（1~5） |
| Knowledge_point  | varchar | 255  | 考察知识点考察知识点 | 可以为空    |
| Spare            |         |      | 备用                 |             |

------

## SourceInfo

方便查询 不设计年级学院专业编号表  直接存储在课程信息中

课程 科目信息

| 字段        | 类型    | 位数 | 说明         | 备注 |
| ----------- | ------- | ---- | ------------ | ---- |
| Source_id   | varchar | 10   | 课程信息编号 | 主键 |
| Source_name | varchar | 20   | 课程科目名   |      |
| Grade       | varchar | 20   | 年级         |      |
| Institute   | varchar | 20   | 学院         |      |
| Major       | varchar | 50   | 专业         |      |
| T_id        | varchar | 20   | 教师工号     |      |
| Spare       |         |      | 备用         |      |

------



## StudentPaper

学生答卷记录

| 字段           | 类型    | 位数 | 说明         | 备注                                |
| -------------- | ------- | ---- | ------------ | ----------------------------------- |
| Exam_id        | varchar | 20   | 考试编号     | 主键                                |
| S_id           | varchar | 20   | 学号         | 主键                                |
| Record_id      | varchar | 20   | 答卷记录编号 |                                     |
| Source_id      | varchar | 10   | 课程信息编号 |                                     |
| ExanQu_num     | varchar | 2    | 试卷题目编号 |                                     |
| Question_mark  | varchar | 3    | 题目分值     |                                     |
| Answer_time    | date    |      | 答题时间     | 不好实现就不做                      |
| Student_answer | varchar | 255  | 答案         |                                     |
| Student_mark   | varchar | 3    | 得分         | 约束  不大于题目分值 （-1为未批阅） |
| Spare          |         |      | 备用         |                                     |

------

## PaperResult

------

| 字段           | 类型    | 位数 | 说明         | 备注                                  |
| -------------- | ------- | ---- | ------------ | ------------------------------------- |
| Record_id      | varchar | 20   | 答卷记录编号 | 主键                                  |
| T_id           | varchar | 20   | 教师工号     | 主键                                  |
| Exam_id        | varchar | 20   | 考试编号     |                                       |
| ExanQu_num     | varchar | 2    | 试卷题目编号 |                                       |
| Question_mark  | varchar | 3    | 题目分值     |                                       |
| Reviw_time     | date    |      | 批阅时间     | 不好实现就不做                        |
| Teacher_mark   | varchar | 3    | 给分         | 给分以后赋值StudentPaper.Student_mark |
| Teacher_remark | varchar | 255  | 评语         |                                       |
| Spare          |         |      | 备用         |                                       |

------

## StudentExam

学生考试信息统计

总成绩：从答题记录计算

| 字段         | 类型    | 位数 | 说明         | 备注                |
| ------------ | ------- | ---- | ------------ | ------------------- |
| S_id         | varchar | 20   | 学号         | 主键                |
| Exam_id      | varchar | 20   | 考试编号     | 主键                |
| Source_id    | varchar | 10   | 课程信息编号 |                     |
| S_totalscore | varchar | 5    | 总成绩       | 缺省-1   标记未参加 |
| Spare        |         |      | 备用         |                     |

------

## News

| 字段        | 类型    | 位数    | 说明                | 备注                                |
| ----------- | ------- | ------- | ------------------- | ----------------------------------- |
| N_id        | varchar | 20      | 编号                | 主键                                |
| N_title     | varchar | varchar | 标题                |                                     |
| N_time      | date    |         | 发布时间            |                                     |
| Author_tpye | varchar | 2       | 发布者身份          | 教师发布学习信息 管理员发布系统通知 |
| Author_id   | varchar | 20      | 教师工号/管理员工号 |                                     |
| N_content   | varchar | 255     | 内容                |                                     |
| N_type      | varchar | 2       | 类型                | 0：只读  1：需确认   2：需回复      |
| Spare       |         |         | 备用                |                                     |



------

## Message

提问

| 字段      | 类型    | 位数 | 说明     | 备注 |
| --------- | ------- | ---- | -------- | ---- |
| M_id      | varchar | 20   | 编号     |      |
| M_title   | varchar | 20   | 标题     |      |
| M_time    | date    |      | 留言时间 |      |
| S_id      | varchar | 20   | 学号     |      |
| T_id      | varchar | 20   | 向谁提问 |      |
| M_content | varchar | 255  | 内容     |      |
| Spare     |         |      | 备用     |      |



------

## Replay

回复

| 字段      | 类型    | 位数 | 说明              | 备注 |
| --------- | ------- | ---- | ----------------- | ---- |
| R_id      | varchar | 20   | 编号              |      |
| R_title   | varchar | 20   | 标题              |      |
| R_content | varchar | 255  | 内容              |      |
| R_time    | date    |      | 回复时间          |      |
| M_id      | varchar | 20   | 回复的message编号 |      |
| T_id      | varchar | 20   | 回复人            |      |
| Spare     |         |      | 备用              |      |

------

## AuthorityManage

权限管理

| 字段 | 类型 | 位数 | 说明 | 备注 |
| ---- | ---- | ---- | ---- | ---- |
|      |      |      |      |      |
|      |      |      |      |      |
|      |      |      |      |      |


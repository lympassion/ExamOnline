#  ExamOnline数据库设计

------



## 数据表清单

打对勾的为已经确定的表

简答题先不弄了  不能自动得分

| **数据库名称**       | **ExamOnline**                    |
| -------------------- | --------------------------------- |
| **开发环境**         | **MySQL**                         |
| **表名**             | **说明**                          |
| student              | 学生   √                          |
| teacher              | 教师     √                        |
| admin                | 管理员√                           |
| examManage           | 考试管理  安排考试等√             |
| paperManage          | 试卷管理√                         |
| question             | 题库√                             |
| SAQ                  | 简答题                            |
| subjectInfo          | 课程信息√                         |
| student_paper_record | 学生答卷√                         |
| paper_result         | 教师批阅结果  含各题目成绩        |
| student_exam         | 学生考试信息 已参加未参加  总成绩 |
| news                 | 公告、通知√                       |
| message              | 学生留言、提问√                   |
| replay               | 教师答复√                         |
| authorityManage      | 权限管理                          |

------

## student

便于查询某年级 某专业成绩

注册时候最好搞个邮箱

和年级学院专业课程信息匹配   给学生添加考试课程

| 字段             | 类型    | 位数 | 说明     | 备注                   |
| ---------------- | ------- | ---- | -------- | ---------------------- |
| student_id       | int     | 20   | 学号     | 主键、自增             |
| student_name     | varchar | 20   | 学生姓名 | not null               |
| student_class    | varchar | 20   | 班级     |                        |
| student_email    | varchar | 30   | 学生邮箱 |                        |
| student_password | varchar | 16   | 学生密码 | not null               |
| student_gender   | varchar | 2    | 性别     | 约束（男，女）NOT NULL |
| Spare            |         |      | 备用     |                        |

------

## teacher

可以搞一个教师的简介页面

| 字段             | 类型    | 位数 | 说明     | 备注                   |
| ---------------- | ------- | ---- | -------- | ---------------------- |
| teacher_id       | varchar | 20   | 教师工号 | 主键                   |
| teacher_name     | varchar | 20   | 教师姓名 | NOT NULL               |
| teacher_gender   | varchar | 2    | 性别     | 约束（男，女）NOT NULL |
| teacher_email    | varchar | 30   | 教师邮箱 | NOT NULL               |
| teacher_password | varchar | 16   | 教师密码 | NOT NULL               |
| Spare            |         |      | 备用     |                        |

------

## admin

| 字段           | 类型    | 位数 | 说明       | 备注                   |
| -------------- | ------- | ---- | ---------- | ---------------------- |
| admin_id       | varchar | 20   | 管理员工号 | 主键                   |
| admin_name     | varchar | 20   | 管理员姓名 | NOT NULL               |
| admin_gender   | varchar | 2    | 性别       | 约束（男，女）NOT NULL |
| admin_email    | varchar | 20   | 管理员邮箱 | NOT NULL               |
| admin_password | varchar | 16   | 管理员密码 | NOT NULL               |
| Spare          |         |      | 备用       |                        |

------

## exam

排考

| 字段        | 类型    | 位数 | 说明     | 备注               |
| ----------- | ------- | ---- | -------- | ------------------ |
| exam_id     | varchar | 20   | 考试编号 | 主键               |
| exam_name   | varchar | 50   | 考试名称 |                    |
| course_id   | int     | 10   | 课程信息 | 外键               |
| paper_id    | int     | 10   | 试卷编号 | 外键，（要是主键） |
| total_score | int     | 3    | 试卷总分 | 随机组题           |
| start_time  | date    |      | 开始时间 | 可以进入考试的时间 |
| end_time    | date    |      | 结束时间 | 考试结束的时间     |
| exam_time   | int     | 4    | 持续时间 |                    |
| Spare       |         |      | 备用     |                    |

------

## paper

所有题目的难度加起来计算试卷难度  难度在某个区间设置种难度级别

| 字段          | 类型    | 位数 | 说明         | 备注                 |
| ------------- | ------- | ---- | ------------ | -------------------- |
| id            | int     |      | 选题记录     | 主键自增             |
| paper_id      | varchar | 10   | 试卷编号     |                      |
| course_id     | int     |      | 课程信息     | 外键                 |
| question_num  | varchar | 3    | 试卷题目编号 | 1~xx                 |
| question_type | enum    | 2    | 试题类型     | 约束（）             |
| question_id   | int     | 10   | 试题编号     | 题库中的编号         |
| question_mark | varchar | 3    | 试题分数     | default -1  未赋分值 |

------

## question

| 字段             | 类型    | 位数 | 说明         | 备注        |
| ---------------- | ------- | ---- | ------------ | ----------- |
| question_id      | int     | 10   | 试题编号     | 主键、自增  |
| question_type    | enum    | 2    | 试题类型     | not null    |
| course_id        | varchar | 10   | 考试课程信息 | 外键        |
| question_content | varchar | 255  | 题目内容     |             |
| opA              | varchar | 255  | 选项A        | 判断题就是T |
| opB              | varchar | 255  | 选项B        | 判断题就是F |
| opC              | varchar | 255  | 选项C        |             |
| opD              | varchar | 255  | 选项D        |             |
| question_answer  | varchar | 2    | 正确答案     |             |

------



## SAQ//

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

## course_info

方便查询 不设计年级学院专业编号表  直接存储在课程信息中

课程 科目信息

| 字段        | 类型    | 位数 | 说明       | 备注 |
| ----------- | ------- | ---- | ---------- | ---- |
| course_id   | int     | 10   | 课程编号   | 主键 |
| course_name | varchar | 20   | 课程科目名 |      |

------



## student_paper_record

学生答卷记录

| 字段           | 类型    | 位数 | 说明         | 备注                                |
| -------------- | ------- | ---- | ------------ | ----------------------------------- |
| record_id      | int     | 20   | 答卷记录编号 | 主键                                |
| exam_id        | int     | 10   | 考试编号     | 外键                                |
| student_id     | varchar | 20   | 学号         | 外键                                |
| student_answer | varchar | 255  | 答案         |                                     |
| student_mark   | int     | 3    | 得分         | 约束  不大于题目分值 （-1为未批阅） |
| Spare          |         |      | 备用         |                                     |

------

## teacher_record//

------

| 字段           | 类型    | 位数 | 说明         | 备注                                  |
| -------------- | ------- | ---- | ------------ | ------------------------------------- |
| record_id      | varchar | 20   | 答卷记录编号 | 主键                                  |
| T_id           | varchar | 20   | 教师工号     | 主键                                  |
| Exam_id        | varchar | 20   | 考试编号     |                                       |
| ExanQu_num     | varchar | 2    | 试卷题目编号 |                                       |
| Question_mark  | varchar | 3    | 题目分值     |                                       |
| Reviw_time     | date    |      | 批阅时间     | 不好实现就不做                        |
| Teacher_mark   | varchar | 3    | 给分         | 给分以后赋值StudentPaper.Student_mark |
| Teacher_remark | varchar | 255  | 评语         |                                       |
| Spare          |         |      | 备用         |                                       |

------

## StudentExam//

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

## news

| 字段         | 类型    | 位数    | 说明     | 备注 |
| ------------ | ------- | ------- | -------- | ---- |
| news_id      | varchar | 20      | 编号     | 主键 |
| news_title   | varchar | varchar | 标题     |      |
| news_time    | date    |         | 发布时间 |      |
| news_content | varchar | 255     | 内容     |      |



------

## message

提问

| 字段       | 类型    | 位数 | 说明     | 备注 |
| ---------- | ------- | ---- | -------- | ---- |
| message_id | varchar | 20   | 编号     |      |
| M_title    | varchar | 20   | 标题     |      |
| M_time     | date    |      | 留言时间 |      |
| S_id       | varchar | 20   | 学号     |      |
| T_id       | varchar | 20   | 向谁提问 |      |
| M_content  | varchar | 255  | 内容     |      |
| Spare      |         |      | 备用     |      |



------

## replay

回复

| 字段              | 类型    | 位数 | 说明              | 备注 |
| ----------------- | ------- | ---- | ----------------- | ---- |
| replay_id         | varchar | 20   | 编号              |      |
| replay_title      | varchar | 20   | 标题              |      |
| replay_content    | varchar | 255  | 内容              |      |
| replay_time       | date    |      | 回复时间          |      |
| replay_message_id | varchar | 20   | 回复的message编号 |      |
| replay_teacher_id | varchar | 20   | 回复人            |      |

------

## AuthorityManage..

权限管理

| 字段 | 类型 | 位数 | 说明 | 备注 |
| ---- | ---- | ---- | ---- | ---- |
|      |      |      |      |      |
|      |      |      |      |      |
|      |      |      |      |      |


/*
 Navicat Premium Data Transfer

 Source Server         : origin
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 15/07/2021 20:27:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(0) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_gender` int(0) NOT NULL,
  `admin_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (30000000, 'aa', 1, '999@qq.com', '123456');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `class_id` int(0) NOT NULL,
  `course_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teacher_id` int(0) NOT NULL,
  PRIMARY KEY (`class_id`) USING BTREE,
  INDEX `teacherid`(`teacher_id`) USING BTREE,
  CONSTRAINT `teacherid` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `exam_id` int(0) NOT NULL AUTO_INCREMENT,
  `exam_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `paper_id` int(0) NOT NULL,
  `total_score` int(0) NOT NULL,
  `start_time` timestamp(0) NOT NULL,
  `end_time` timestamp(0) NOT NULL,
  `exam_time` int(0) NOT NULL,
  PRIMARY KEY (`exam_id`) USING BTREE,
  INDEX `course_id2`(`course_name`) USING BTREE,
  INDEX `paper_id`(`paper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES (1, 'python-test', 'python', 100, 60, '2021-07-12 15:12:50', '2021-07-16 20:13:05', 7200);
INSERT INTO `exam` VALUES (2, 'python补考', 'python', 100, 60, '2021-07-01 15:17:55', '2021-07-06 15:18:01', 7200);
INSERT INTO `exam` VALUES (3, 'python-mid', 'python', 100, 60, '2021-07-23 15:18:35', '2021-07-29 15:18:39', 7200);

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `paper_id` int(0) NOT NULL,
  `course_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `question_type` int(0) NOT NULL,
  `question_id` int(0) NOT NULL,
  `question_order` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `question_id`(`question_id`) USING BTREE,
  INDEX `course_id`(`course_name`) USING BTREE,
  INDEX `question_type`(`question_type`) USING BTREE,
  INDEX `paper_id`(`paper_id`) USING BTREE,
  CONSTRAINT `paperid` FOREIGN KEY (`paper_id`) REFERENCES `real_paper` (`paper_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES (1, 100, 'python', 0, 2, 0);
INSERT INTO `paper` VALUES (2, 100, 'python', 0, 75, 1);
INSERT INTO `paper` VALUES (3, 100, 'python', 1, 78, 2);
INSERT INTO `paper` VALUES (4, 100, 'python', 1, 79, 3);
INSERT INTO `paper` VALUES (5, 100, 'python', 2, 84, 4);
INSERT INTO `paper` VALUES (6, 100, 'python', 2, 85, 5);
INSERT INTO `paper` VALUES (7, 100, 'python', 4, 93, 7);
INSERT INTO `paper` VALUES (8, 100, 'python', 4, 94, 8);
INSERT INTO `paper` VALUES (9, 100, 'python', 2, 9, 6);

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `question_id` int(0) NOT NULL AUTO_INCREMENT,
  `question_type` int(0) NOT NULL,
  `course_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `question_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `opa` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `opb` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `opc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `opd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `question_answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `question_score` int(0) NOT NULL,
  PRIMARY KEY (`question_id`) USING BTREE,
  INDEX `course_id1`(`course_name`) USING BTREE,
  INDEX `question_type`(`question_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, 0, 'java', '下列说法正确的是', 'JAVA程序的main方法必须写在类里面', 'JAVA程序中可以有多个main方法', 'JAVA程序中类名必须与文件名一样', 'JAVA程序的main方法中如果只有一条语句，可以不用{}(大括号)括起来', 'A', 5);
INSERT INTO `question` VALUES (2, 0, 'python', '下面哪个不是Python合法的标识符', 'int32', '40XL', 'self', '__name__', 'B', 5);
INSERT INTO `question` VALUES (3, 0, 'java', '下列值不为true的表达式有', '\"john\" = = \"john\"', '\"john\".equals(\"john\")', '\"john\" = \"john\"', '\"john\".equals(new String(\"john\"))', 'C', 5);
INSERT INTO `question` VALUES (4, 0, 'java', '假设web应用的文档根目录为MyApp，那么可以从哪里找到database.jar文件', 'MyApp目录下', 'MyApp\\images目录下', 'MyApp\\WEB-INF目录下', 'MyApp\\WEB-INF\\lib目录下', 'D', 5);
INSERT INTO `question` VALUES (5, 0, 'java', '从以下哪一个选项中可以获得Servlet的初始化参数', 'Servlet', 'ServletContext', 'ServletConfig', 'GenericServlet', 'C', 5);
INSERT INTO `question` VALUES (6, 0, 'java', '哪一个对象可以用于获得浏览器发送的请求', 'HttpServletRequest', 'HttpServletResponse', 'HttpServlet', 'Http', 'A', 5);
INSERT INTO `question` VALUES (7, 1, 'java', '下面哪些关键字能用来控制对类成员的访问', 'public', 'private', 'protected', 'default', 'ABC', 5);
INSERT INTO `question` VALUES (8, 2, 'java', '描述对象的两个要素是属性和方法', 'T', 'F', NULL, NULL, 'T', 5);
INSERT INTO `question` VALUES (9, 2, 'python', '列表中的元素可以是不同数据类型 ', 'T', 'F', '', '', 'T', 5);
INSERT INTO `question` VALUES (10, 2, 'python', '元组中的元素是不可更改的', 'T', 'F', NULL, NULL, 'T', 5);
INSERT INTO `question` VALUES (11, 2, 'python', 'python不能多继承', 'T', 'F', NULL, NULL, 'F', 5);
INSERT INTO `question` VALUES (12, 0, 'C', '__是构成C语言程序的基本单位', '函数', '过程', '子程序', '子例程', 'A', 5);
INSERT INTO `question` VALUES (13, 0, 'C', 'C语言程序从__开始执行', '程序中第一条可执行语句', '程序中第一个函数', '程序中的main函数 ', '包含文件中的第一个函数', 'C', 5);
INSERT INTO `question` VALUES (14, 0, 'java', '在类的定义中可以有两个同名函数，这种现象称为函数', '封装', '继承', '重载', '覆盖', 'C', 5);
INSERT INTO `question` VALUES (15, 0, 'java', '如果一个类的成员变量只能在所在类中使用，则该成员变量必须使用的修饰是', 'public ', 'protected', 'private', 'static', 'C', 5);
INSERT INTO `question` VALUES (16, 0, 'java', '哪个关键字可以对对象加互斥锁？', 'transient', 'synchronized', 'serialize', 'static', 'B', 5);
INSERT INTO `question` VALUES (17, 0, 'java', '关于抽象方法的说法正确的是', '可以有方法体', '可以出现在非抽象类中', '是没有方法体的方法', '抽象类中的方法都是抽象方法', 'D', 5);
INSERT INTO `question` VALUES (18, 0, 'java', 'java.io 包的File 类是', '字符流', '字节流类然后引用filestream', '对象流类', '非流类', 'B', 5);
INSERT INTO `question` VALUES (19, 0, 'java', '以下关于继承的叙述正确的是', '在Java 中类只允许单一继承', '在Java 中一个类只能实现一个接口', '在Java 中一个类不能同时继承一个类和实现一个接口', '在Java 中接口只允许单一继承', 'A', 5);
INSERT INTO `question` VALUES (20, 0, 'java', '若有定义：byte[] x={11,22,33,-66};</p> <p>其中0≤k ≤3，则对x 数组元素错误的引用是', 'x[5-3]', 'x[k]', 'x[k+5]', 'x[0]', 'C', 5);
INSERT INTO `question` VALUES (21, 1, 'java', '下面能让线程停止执行的有', ' sleep()', 'stop()', 'notify()', 'synchronized()', 'ABD', 5);
INSERT INTO `question` VALUES (22, 0, 'java', '下面哪个可以改变容器的布局', 'setLayout(aLayoutManager)', 'addLayout(aLayoutManager)', 'layout(aLayoutManager)', 'setLayoutManager(aLayoutManager)', 'A', 5);
INSERT INTO `question` VALUES (23, 0, 'java', '下面哪个是applet传递参数的正确方式', '<applet code=Test.class age=33 width=1 height=1>', '<param name=age value=33>', '<applet code=Test.class name=age value=33 width=1 height=1>', '<applet Test 33>', 'B', 5);
INSERT INTO `question` VALUES (24, 0, 'java', '提供Java存取数据库能力的包是', 'java.sql', 'java.awt', 'java.lang', 'java.swing', 'A', 5);
INSERT INTO `question` VALUES (25, 1, 'java', '不能用来修饰interface的有', 'private', 'public', 'protected', 'static', 'ACD', 5);
INSERT INTO `question` VALUES (26, 1, 'java', '下列说法错误的有', '在类方法中可用this来调用本类的类方法', '在类方法中调用本类的类方法时可直接调用', '在类方法中只能调用本类中的类方法', '在类方法中绝对不能调用实例方法', 'ACD', 5);
INSERT INTO `question` VALUES (27, 1, 'java', '有关线程的哪些叙述是对的', '一旦一个线程被创建，它就立即开始运行。', '使用start()方法可以使一个线程成为可运行的，但是它不一定立即开始运行', '当一个线程因为抢先机制而停止运行，它被放在可运行队列的前面', '一个线程可能因为不同的原因停止并进入就绪状态', 'BCD', 5);
INSERT INTO `question` VALUES (28, 1, 'java', '下面的哪些声明是合法的？', 'long 1 = 499', 'int i = 4L', 'float f =1.1', 'double d = 34.4', 'AD', 5);
INSERT INTO `question` VALUES (29, 1, 'java', ' 选择Java语言中的基本数据类型', '.byte', 'Integer', 'char', 'long', 'ACD', 5);
INSERT INTO `question` VALUES (30, 1, 'java', '从下列选项中选择正确的Java表达式', 'int k=new String(“aa”)', 'String str=String(“bb”)', 'char c=74;', 'long j=8888;', 'BCD', 5);
INSERT INTO `question` VALUES (31, 1, 'java', '关于Java语言，下列描述正确的是', ' switch 不能够作用在String类型上', 'List， Set， Map都继承自Collection接口', 'Java语言支持goto语句', 'GC是垃圾收集器，程序员不用担心内存管理', 'AD', 5);
INSERT INTO `question` VALUES (32, 1, 'java', '下列描述中，哪些符合Java语言的特征', '支持跨平台(Windows，Linux，Unix等)', 'GC(自动垃圾回收)，提高了代码安全性', '支持类C的指针运算操作', '不支持与其它语言书写的程序进行通讯', 'AB', 5);
INSERT INTO `question` VALUES (33, 2, 'java', '序列图描述对象是如何交互的并且将重点放在消息序列上', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (34, 2, 'java', '一个XML必须有DTD或Schemas', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (35, 1, 'java', '下列哪些是J2EE的体系', 'JSP', 'JAVA', 'Servlet', 'WebService', 'ACD', 5);
INSERT INTO `question` VALUES (36, 0, 'java', '在Struts中实现页面跳转主要通过什么方法来实现', 'server.transfer', 'response.redirect', 'mapping.findForward', 'response.sendRedirect', 'C', 5);
INSERT INTO `question` VALUES (37, 2, 'java', '用final修饰的变量叫常量', 'T', 'F', '', '', 'T', 5);
INSERT INTO `question` VALUES (38, 2, 'java', 'Java支持多重继承', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (39, 2, 'java', '一个类可以实现多接口', 'T', 'F', '', '', 'T', 5);
INSERT INTO `question` VALUES (40, 2, 'java', 'Java语言是编译解释型语言', 'T', 'F', '', '', 'T', 5);
INSERT INTO `question` VALUES (41, 2, 'java', '一个类实现一个接口，则该类必须实现接口中的所有方法', 'T', 'F', '', '', 'T', 5);
INSERT INTO `question` VALUES (42, 2, 'java', '在方法定义中，可能发生的异常都必须用try{} catch ){}捕捉', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (43, 2, 'java', 'Java 语言的标识符是不区分大小写的', 'T', 'F', '', '', 'T', 5);
INSERT INTO `question` VALUES (44, 0, 'C', 'C语言中主函数的个数', '1', '2', '无穷', '任意', 'A', 5);
INSERT INTO `question` VALUES (45, 0, 'C', 'c语言源程序文件后缀为', '.EXE', '.obj', '.c', '.java', 'C', 5);
INSERT INTO `question` VALUES (46, 0, 'C', 'C语言属于__语言', '机器语言', '汇编语言', '高级语言', '面向对象语言', 'B', 5);
INSERT INTO `question` VALUES (47, 0, 'C', 'C语言中普通整型变量int在内存中占__字节', '1', '2', '3', '4', 'B', 5);
INSERT INTO `question` VALUES (48, 0, 'C', '下列不是C语言基本数据类型的是  ', '字符型', '整型 ', '浮点型', '结构体', 'A', 5);
INSERT INTO `question` VALUES (49, 0, 'C', '有关自增、自减运算,以下只有__是正确的', 'a-b++', '---f ', '++78', 'a--', 'D', 5);
INSERT INTO `question` VALUES (50, 0, 'C', '有关自增、自减运算,以下只有__是正确的', '1', '2', '3', '0', 'D', 5);
INSERT INTO `question` VALUES (51, 0, 'C', '有关自增、自减运算,以下只有__是正确的', 'if', '_xy', 'case', '0xy', 'B', 5);
INSERT INTO `question` VALUES (52, 2, 'C', '“A”是一个字符常量', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (53, 2, 'C', '在程序运行过程中其值可以改变的量称为变量', 'T', 'F', '', '', 'T', 5);
INSERT INTO `question` VALUES (54, 2, 'C', '在C语言中，变量可以先使用再定义', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (55, 2, 'C', '在C语言中，所有算术运算符的优先级都相同', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (56, 2, 'C', '程序中若要使用数学函数就必须包含头文件{stdio.h}', 'T', 'F', '', '', 'T', 5);
INSERT INTO `question` VALUES (57, 2, 'C', '在标准C中，“=”是判断两个数是否相等', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (58, 2, 'C', '/%20运算符要求运算数必须是整数', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (59, 2, 'C', 'Int, #a15 , char都是合法的标识符', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (60, 2, 'C', '算法要有一定的逻辑性和健壮性', 'T', 'F', '', '', 'T', 5);
INSERT INTO `question` VALUES (61, 0, 'C', 'C语言的输入与输出操作是由__完成的', '输入语句 ', '输出语句 ', '输入与输出函数', '传入传出语句', 'C', 5);
INSERT INTO `question` VALUES (62, 0, 'C', '以下哪个数学函数的作用是求某数的平方根 ', 'sqrt()', 'fabs()', 'pow() ', 'exp()', 'A', 5);
INSERT INTO `question` VALUES (63, 1, 'C', '以下可以定义为用户标识符的有 ', 'scanf', 'short ', '_3com_', 'int', 'AC', 5);
INSERT INTO `question` VALUES (64, 1, 'C', '以下选项中不是C语言合法整数的是', '10110 ', '0386', '0Xffa', 'x2a2', 'BD', 5);
INSERT INTO `question` VALUES (65, 1, 'C', '以下合法的十六进制数是', 'oxff ', '0Xabc ', '0x01 ', '0X9X', 'BC', 5);
INSERT INTO `question` VALUES (66, 1, 'C', '以下4个选项中,可以看作是一条语句的有', '{;} ', 'a=0,b=0,c=0', 'if(a>0)', 'if', 'ABC', 5);
INSERT INTO `question` VALUES (67, 1, 'C', '以下对C语言中的函数描述不正确的有()', '可以嵌套定义,不可以嵌套调用', '不可以嵌套定义,可以嵌套调用', '可以嵌套定义,也可以嵌套调用 ', '嵌套定义和嵌套调用都不允许', 'ACD', 5);
INSERT INTO `question` VALUES (68, 1, 'C', '下列选项中是C语言合法标志符的有', 'good_morning', 'main ', 'stdio.h', '8abc', 'AB', 5);
INSERT INTO `question` VALUES (69, 1, 'C', '以下不合法的赋值语句是', 'x=y=100', 'd--', 'x y;', 'c=int(a b)', 'ACD', 5);
INSERT INTO `question` VALUES (70, 0, 'python', '下列哪种说法是错误的', '除字典类型外，所有标准对象均可以用于布尔测试', '空字符串的布尔值是False', '空列表对象的布尔值是False', '值为0的任何数字对象的布尔值是False', 'A', 5);
INSERT INTO `question` VALUES (71, 0, 'python', 'Python不支持的数据类型有', 'char ', 'int ', 'float', 'list', 'A', 5);
INSERT INTO `question` VALUES (72, 0, 'python', '关于Python中的复数，下列说法错误的是', '表示复数的语法是real + image j ', '实部和虚部都是浮点数 ', '虚部必须后缀j，且必须是小写  ', '方法conjugate返回复数的共轭复数', 'C', 5);
INSERT INTO `question` VALUES (73, 0, 'python', '关于字符串下列说法错误的是 ', '字符应该视为长度为1的字符串', '字符串以\\0标志字符串的结束', '既可以用单引号，也可以用双引号创建字符串', '在三引号字符串中可以包含换行回车等特殊字符', 'B', 5);
INSERT INTO `question` VALUES (74, 0, 'python', '以下不能创建一个字典的语句是 ', 'dict1 = {}', 'dict2 = { 3 : 5 }', 'dict3 = {[1,2,3]: “uestc”}', 'dict4 = {(1,2,3): “uestc”}', 'C', 5);
INSERT INTO `question` VALUES (75, 0, 'python', '下列Python语句正确的是 ', 'min = x  if  x < y  else  y ', 'max = x > y ? x : y', 'if (x > y) print x', 'while True : pass', 'D', 5);
INSERT INTO `question` VALUES (76, 0, 'python', 'python源程序执行的方式', '编译执行 ', '解析执行', '直接执行', '边编译边执行', 'B', 5);
INSERT INTO `question` VALUES (77, 0, 'python', ' 以下是字符转换成字节的方法是', ' decode() ', ' encode()', 'upper() ', ' rstrip()', 'B', 5);
INSERT INTO `question` VALUES (78, 1, 'python', '以下是正确的字符串', '‘abc”ab”', '‘abc”ab’', '“abc”ab”', '“abc\\”ab”', 'BD', 5);
INSERT INTO `question` VALUES (79, 1, 'python', '下面对count（），index(), find()方法描述错误的是', 'count() 方法用于统计字符串里某个字符出现的次数 ', 'find() 方法检测字符串中是否包含子字符串 str  如果包含子字符串返回开始的索引值，否则会报一个异常', 'index() 方法检测字符串中是否包含子字符串 str， 如果str不在 返回-1', '以上都错误', 'BD', 5);
INSERT INTO `question` VALUES (80, 1, 'python', '下面说明错误的是', '该类实例中包含__dir__（）方法', '该类实例中包含__hash__（）方法', '该类实例中只包含__dir__（），不包含__hash__（）', '该类没有定义任何方法，所以该实例中没有包含任何方法', 'CD', 5);
INSERT INTO `question` VALUES (81, 0, 'python', '以下哪项python能正常启动', '拼写错误  ', '错误表达式', '缩进错误 ', ' 手动抛出异常', 'D', 5);
INSERT INTO `question` VALUES (82, 0, 'python', '有关异常说法正确的是', '程序中抛出异常终止程序', '程序中抛出异常不一定终止程序', '拼写错误会导致程序终止', ' 缩进错误会导致程序终止', 'B', 5);
INSERT INTO `question` VALUES (83, 2, 'python', '拼写错误会导致程序终止', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (84, 2, 'python', '可以不加声明就使用变量', 'T', 'F', '', '', 'T', 5);
INSERT INTO `question` VALUES (85, 2, 'python', '一个函数中只允许有一条return语句', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (86, 2, 'python', 'Python语言是面向对象的', 'T', 'F', '', '', 'T', 5);
INSERT INTO `question` VALUES (87, 2, 'python', '存在一个程序判别一个Python程序的运行是否可以停止', 'T', 'F', '', '', 'F', 5);
INSERT INTO `question` VALUES (88, 1, 'python', 'Python支持的数据类型有 ', 'char ', 'int ', 'float ', 'list', 'BCD', 5);
INSERT INTO `question` VALUES (89, 1, 'python', '下列Python语句不正确的是', 'min = x if x < y else y ', 'max = x > y and x : y  ', 'if (x > y) print x ', 'while True : pass', 'ABC', 5);
INSERT INTO `question` VALUES (90, 1, 'python', '下面哪个是Python合法的标识符', 'int32', '40XL', 'self*', 'name', 'AD', 5);
INSERT INTO `question` VALUES (91, 1, 'python', '关于 Python 语言的特点，以下选项中描述正确的是 ', 'Python 语言是非开源语言', 'Python 语言是跨平台语言', 'Python 语言是多模型语言', 'Python 语言是脚本语言', 'BCD', 5);
INSERT INTO `question` VALUES (92, 1, 'python', '以下选项属于程序设计语言类别的是', '机器语言', '汇编语言', '高级语言', '解释语言', 'ABC', 5);
INSERT INTO `question` VALUES (93, 4, 'python', '用python编程实现:输入一个六位数，求各位数之和，如果各位数之和为36-45，则此数字为幸运数字。', '', '', '', '', '', 15);
INSERT INTO `question` VALUES (94, 4, 'python', '用python编程实现:某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。试输入一个数，并求出对应的数字。', '', '', '', '', '', 15);

-- ----------------------------
-- Table structure for real_paper
-- ----------------------------
DROP TABLE IF EXISTS `real_paper`;
CREATE TABLE `real_paper`  (
  `paper_id` int(0) NOT NULL AUTO_INCREMENT,
  `paper_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `paper_score` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`paper_id`) USING BTREE,
  UNIQUE INDEX `papername`(`paper_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of real_paper
-- ----------------------------
INSERT INTO `real_paper` VALUES (100, 'python-test', 'python', 60);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int(0) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `student_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `student_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_gender` int(0) NOT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10000020 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (10000000, 'wang', '1', '112@qq.com', '123456', 0);
INSERT INTO `student` VALUES (10000015, '张三', '三年一班', '123@qq.com', '123456', 0);
INSERT INTO `student` VALUES (10000016, '张三', '三年一班', '123@qq.com', '123456', 0);
INSERT INTO `student` VALUES (10000017, '张三', '三年一班', '123@qq.com', '123456', 0);
INSERT INTO `student` VALUES (10000018, '张三', '三年一班', '123@qq.com', '123456', 0);
INSERT INTO `student` VALUES (10000019, '张三', '三年一班', '123@qq.com', '123456', 0);
INSERT INTO `student` VALUES (10000020, 'lolit', '三年一班', '123@qq.com', '123456', 0);

-- ----------------------------
-- Table structure for student_exam
-- ----------------------------
DROP TABLE IF EXISTS `student_exam`;
CREATE TABLE `student_exam`  (
  `result_id` int(0) NOT NULL AUTO_INCREMENT,
  `exam_id` int(0) NOT NULL,
  `student_id` int(0) NOT NULL,
  `student_answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `student_score` int(0) UNSIGNED NULL DEFAULT NULL,
  `question_id` int(0) NOT NULL,
  PRIMARY KEY (`result_id`) USING BTREE,
  INDEX `exam_id1`(`exam_id`) USING BTREE,
  INDEX `student_id1`(`student_id`) USING BTREE,
  INDEX `qusetion_id2`(`question_id`) USING BTREE,
  CONSTRAINT `exam_id1` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `qusetion_id2` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_id1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_exam
-- ----------------------------

-- ----------------------------
-- Table structure for student_paper_record
-- ----------------------------
DROP TABLE IF EXISTS `student_paper_record`;
CREATE TABLE `student_paper_record`  (
  `record_id` int(0) NOT NULL,
  `exam_id` int(0) NOT NULL,
  `student_id` int(0) NOT NULL,
  `student_mark` int(0) NOT NULL DEFAULT -1,
  PRIMARY KEY (`record_id`) USING BTREE,
  INDEX `exam_id`(`exam_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  CONSTRAINT `exam_id` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_paper_record
-- ----------------------------
INSERT INTO `student_paper_record` VALUES (1, 1, 10000000, 0);
INSERT INTO `student_paper_record` VALUES (2, 2, 10000000, -1);
INSERT INTO `student_paper_record` VALUES (3, 3, 10000000, -1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` int(0) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teacher_gender` int(0) NOT NULL,
  `teacher_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teacher_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20000004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (20000000, 'ali', 1, '979@163.com', '123456');
INSERT INTO `teacher` VALUES (20000001, 'bol', 0, '334@qq.com', '123456');
INSERT INTO `teacher` VALUES (20000003, 'sl', 1, '324@qq.com', '123456');
INSERT INTO `teacher` VALUES (20000004, '风昔', 0, 'Mori@gmail.com', '123456');
INSERT INTO `teacher` VALUES (20000005, '风昔', 0, 'Mori@gmail.com', '123456');
INSERT INTO `teacher` VALUES (20000006, '风昔', 0, 'Mori@gmail.com', '123456');

SET FOREIGN_KEY_CHECKS = 1;

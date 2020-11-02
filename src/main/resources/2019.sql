drop database if exists kaoqin;
create database kaoqin;

use kaoqin;
CREATE TABLE `no_work_day` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 2020年不上班的日子，2020年全年节假日含周末，已去除调休成工作日的周末

INSERT INTO `no_work_day` VALUES ('1', '20200101');
INSERT INTO `no_work_day` VALUES ('2', '20200104');
INSERT INTO `no_work_day` VALUES ('3', '20200105');
INSERT INTO `no_work_day` VALUES ('4', '20200111');
INSERT INTO `no_work_day` VALUES ('5', '20200112');
INSERT INTO `no_work_day` VALUES ('6', '20200118');
INSERT INTO `no_work_day` VALUES ('7', '20200119');
INSERT INTO `no_work_day` VALUES ('8', '20200124');
INSERT INTO `no_work_day` VALUES ('9', '20200125');
INSERT INTO `no_work_day` VALUES ('10', '20200126');
INSERT INTO `no_work_day` VALUES ('11', '20200127');
INSERT INTO `no_work_day` VALUES ('12', '20200128');
INSERT INTO `no_work_day` VALUES ('13', '20200129');
INSERT INTO `no_work_day` VALUES ('14', '20200130');
INSERT INTO `no_work_day` VALUES ('15', '20200201');
INSERT INTO `no_work_day` VALUES ('16', '20200202');
INSERT INTO `no_work_day` VALUES ('17', '20200208');
INSERT INTO `no_work_day` VALUES ('18', '20200209');
INSERT INTO `no_work_day` VALUES ('19', '20200215');
INSERT INTO `no_work_day` VALUES ('20', '20200216');
INSERT INTO `no_work_day` VALUES ('21', '20200222');
INSERT INTO `no_work_day` VALUES ('22', '20200223');
INSERT INTO `no_work_day` VALUES ('23', '20200229');
INSERT INTO `no_work_day` VALUES ('24', '20200301');
INSERT INTO `no_work_day` VALUES ('25', '20200307');
INSERT INTO `no_work_day` VALUES ('26', '20200308');
INSERT INTO `no_work_day` VALUES ('27', '20200314');
INSERT INTO `no_work_day` VALUES ('28', '20200315');
INSERT INTO `no_work_day` VALUES ('29', '20200321');
INSERT INTO `no_work_day` VALUES ('30', '20200322');
INSERT INTO `no_work_day` VALUES ('31', '20200328');
INSERT INTO `no_work_day` VALUES ('32', '20200329');
INSERT INTO `no_work_day` VALUES ('33', '20200404');
INSERT INTO `no_work_day` VALUES ('34', '20200405');
INSERT INTO `no_work_day` VALUES ('35', '20200406');
INSERT INTO `no_work_day` VALUES ('36', '20200411');
INSERT INTO `no_work_day` VALUES ('37', '20200412');
INSERT INTO `no_work_day` VALUES ('38', '20200418');
INSERT INTO `no_work_day` VALUES ('39', '20200419');
INSERT INTO `no_work_day` VALUES ('40', '20200425');
INSERT INTO `no_work_day` VALUES ('41', '20200426');
INSERT INTO `no_work_day` VALUES ('42', '20200501');
INSERT INTO `no_work_day` VALUES ('43', '20200502');
INSERT INTO `no_work_day` VALUES ('44', '20200503');
INSERT INTO `no_work_day` VALUES ('45', '20200504');
INSERT INTO `no_work_day` VALUES ('46', '20200505');
INSERT INTO `no_work_day` VALUES ('47', '20200509');
INSERT INTO `no_work_day` VALUES ('48', '20200510');
INSERT INTO `no_work_day` VALUES ('49', '20200516');
INSERT INTO `no_work_day` VALUES ('50', '20200517');
INSERT INTO `no_work_day` VALUES ('51', '20200523');
INSERT INTO `no_work_day` VALUES ('52', '20200524');
INSERT INTO `no_work_day` VALUES ('53', '20200530');
INSERT INTO `no_work_day` VALUES ('54', '20200531');
INSERT INTO `no_work_day` VALUES ('55', '20200606');
INSERT INTO `no_work_day` VALUES ('56', '20200607');
INSERT INTO `no_work_day` VALUES ('57', '20200613');
INSERT INTO `no_work_day` VALUES ('58', '20200614');
INSERT INTO `no_work_day` VALUES ('59', '20200620');
INSERT INTO `no_work_day` VALUES ('60', '20200621');
INSERT INTO `no_work_day` VALUES ('61', '20200625');
INSERT INTO `no_work_day` VALUES ('62', '20200626');
INSERT INTO `no_work_day` VALUES ('63', '20200627');
INSERT INTO `no_work_day` VALUES ('64', '20200628');
INSERT INTO `no_work_day` VALUES ('65', '20200704');
INSERT INTO `no_work_day` VALUES ('66', '20200705');
INSERT INTO `no_work_day` VALUES ('67', '20200711');
INSERT INTO `no_work_day` VALUES ('68', '20200712');
INSERT INTO `no_work_day` VALUES ('69', '20200718');
INSERT INTO `no_work_day` VALUES ('70', '20200719');
INSERT INTO `no_work_day` VALUES ('71', '20200725');
INSERT INTO `no_work_day` VALUES ('72', '20200726');
INSERT INTO `no_work_day` VALUES ('73', '20200801');
INSERT INTO `no_work_day` VALUES ('74', '20200802');
INSERT INTO `no_work_day` VALUES ('75', '20200808');
INSERT INTO `no_work_day` VALUES ('76', '20200809');
INSERT INTO `no_work_day` VALUES ('77', '20200815');
INSERT INTO `no_work_day` VALUES ('78', '20200816');
INSERT INTO `no_work_day` VALUES ('79', '20200822');
INSERT INTO `no_work_day` VALUES ('80', '20200823');
INSERT INTO `no_work_day` VALUES ('81', '20200829');
INSERT INTO `no_work_day` VALUES ('82', '20200830');
INSERT INTO `no_work_day` VALUES ('83', '20200905');
INSERT INTO `no_work_day` VALUES ('84', '20200906');
INSERT INTO `no_work_day` VALUES ('85', '20200912');
INSERT INTO `no_work_day` VALUES ('86', '20200913');
INSERT INTO `no_work_day` VALUES ('87', '20200919');
INSERT INTO `no_work_day` VALUES ('88', '20200920');
INSERT INTO `no_work_day` VALUES ('89', '20200926');
INSERT INTO `no_work_day` VALUES ('90', '20200927');
INSERT INTO `no_work_day` VALUES ('91', '20201001');
INSERT INTO `no_work_day` VALUES ('92', '20201002');
INSERT INTO `no_work_day` VALUES ('93', '20201003');
INSERT INTO `no_work_day` VALUES ('94', '20201004');
INSERT INTO `no_work_day` VALUES ('95', '20201005');
INSERT INTO `no_work_day` VALUES ('96', '20201006');
INSERT INTO `no_work_day` VALUES ('97', '20201007');
INSERT INTO `no_work_day` VALUES ('98', '20201008');
INSERT INTO `no_work_day` VALUES ('99', '20201010');
INSERT INTO `no_work_day` VALUES ('100', '20201011');
INSERT INTO `no_work_day` VALUES ('101', '20201017');
INSERT INTO `no_work_day` VALUES ('102', '20201018');
INSERT INTO `no_work_day` VALUES ('103', '20201024');
INSERT INTO `no_work_day` VALUES ('104', '20201025');
INSERT INTO `no_work_day` VALUES ('105', '20201031');
INSERT INTO `no_work_day` VALUES ('106', '20201101');
INSERT INTO `no_work_day` VALUES ('107', '20201107');
INSERT INTO `no_work_day` VALUES ('108', '20201108');
INSERT INTO `no_work_day` VALUES ('109', '20201114');
INSERT INTO `no_work_day` VALUES ('110', '20201115');
INSERT INTO `no_work_day` VALUES ('111', '20201121');
INSERT INTO `no_work_day` VALUES ('112', '20201122');
INSERT INTO `no_work_day` VALUES ('113', '20201128');
INSERT INTO `no_work_day` VALUES ('114', '20201129');
INSERT INTO `no_work_day` VALUES ('115', '20201205');
INSERT INTO `no_work_day` VALUES ('116', '20201206');
INSERT INTO `no_work_day` VALUES ('117', '20201212');
INSERT INTO `no_work_day` VALUES ('118', '20201213');
INSERT INTO `no_work_day` VALUES ('119', '20201219');
INSERT INTO `no_work_day` VALUES ('120', '20201220');
INSERT INTO `no_work_day` VALUES ('121', '20201226');
INSERT INTO `no_work_day` VALUES ('122', '20201227');



-- 2019年节假日，2019年全年节假日含周末，已去除调休成工作日的周末

INSERT INTO `no_work_day` (`id`, `day`) VALUES ('116', '20190101');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('117', '20190105');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('118', '20190106');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('119', '20190112');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('120', '20190113');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('121', '20190119');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('122', '20190120');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('123', '20190126');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('124', '20190127');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('125', '20190202');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('126', '20190203');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('127', '20190204');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('128', '20190205');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('129', '20190206');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('130', '20190207');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('131', '20190208');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('132', '20190209');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('133', '20190210');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('134', '20190211');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('135', '20190212');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('136', '20190213');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('137', '20190216');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('138', '20190217');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('139', '20190223');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('140', '20190224');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('141', '20190302');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('142', '20190303');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('143', '20190309');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('144', '20190310');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('145', '20190316');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('146', '20190317');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('147', '20190323');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('148', '20190324');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('149', '20190330');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('150', '20190331');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('151', '20190405');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('152', '20190406');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('153', '20190407');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('154', '20190413');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('155', '20190414');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('156', '20190420');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('157', '20190421');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('158', '20190427');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('159', '20190428');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('160', '20190501');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('161', '20190504');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('162', '20190505');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('163', '20190511');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('164', '20190512');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('165', '20190518');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('166', '20190519');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('167', '20190525');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('168', '20190526');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('169', '20190601');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('170', '20190602');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('171', '20190607');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('172', '20190608');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('173', '20190609');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('174', '20190615');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('175', '20190616');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('176', '20190622');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('177', '20190623');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('178', '20190629');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('179', '20190630');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('180', '20190706');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('181', '20190707');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('182', '20190713');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('183', '20190714');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('184', '20190720');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('185', '20190721');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('186', '20190727');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('187', '20190728');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('188', '20190803');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('189', '20190804');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('190', '20190810');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('191', '20190811');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('192', '20190817');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('193', '20190818');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('194', '20190824');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('195', '20190825');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('196', '20190831');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('197', '20190901');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('198', '20190907');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('199', '20190908');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('200', '20190913');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('201', '20190914');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('202', '20190915');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('203', '20190921');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('204', '20190922');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('205', '20190928');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('206', '20191001');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('207', '20191002');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('208', '20191003');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('209', '20191004');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('210', '20191005');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('211', '20191006');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('212', '20191007');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('213', '20191013');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('214', '20191019');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('215', '20191020');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('216', '20191026');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('217', '20191027');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('218', '20191102');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('219', '20191103');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('220', '20191109');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('221', '20191110');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('222', '20191116');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('223', '20191117');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('224', '20191123');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('225', '20191124');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('226', '20191130');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('227', '20191201');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('228', '20191207');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('229', '20191208');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('230', '20191214');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('231', '20191215');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('232', '20191221');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('233', '20191222');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('234', '20191228');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('235', '20191229');
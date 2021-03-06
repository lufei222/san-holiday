-- 下面的sql执行过可不执行 start

drop database if exists kaoqin;
create database kaoqin;

use kaoqin;
CREATE TABLE `no_work_day` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 上面的sql执行过可不执行 end

INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2001', '20210101');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2002', '20210102');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2003', '20210103');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2004', '20210109');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2005', '20210110');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2006', '20210116');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2007', '20210117');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2008', '20210123');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2009', '20210124');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2010', '20210130');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2011', '20210131');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2012', '20210206');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2014', '20210211');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2015', '20210212');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2016', '20210213');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2017', '20210214');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2018', '20210215');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2019', '20210216');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2020', '20210217');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2021', '20210220');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2022', '20210221');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2023', '20210227');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2024', '20210228');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2025', '20210306');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2026', '20210307');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2027', '20210313');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2028', '20210314');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2029', '20210320');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2030', '20210321');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2031', '20210327');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2032', '20210328');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2033', '20210403');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2034', '20210404');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2035', '20210405');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2036', '20210410');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2037', '20210411');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2038', '20210417');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2039', '20210418');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2040', '20210424');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2041', '20210425');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2042', '20210501');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2043', '20210502');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2044', '20210503');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2045', '20210509');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2046', '20210515');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2047', '20210516');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2048', '20210522');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2049', '20210523');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2050', '20210529');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2051', '20210530');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2052', '20210605');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2053', '20210606');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2054', '20210612');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2055', '20210613');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2056', '20210614');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2057', '20210619');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2058', '20210620');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2059', '20210626');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2060', '20210627');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2061', '20210703');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2062', '20210704');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2063', '20210710');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2064', '20210711');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2065', '20210717');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2066', '20210718');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2067', '20210724');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2068', '20210725');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2069', '20210731');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2070', '20210801');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2071', '20210807');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2072', '20210808');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2073', '20210814');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2074', '20210815');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2075', '20210821');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2076', '20210822');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2077', '20210828');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2078', '20210829');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2079', '20210904');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2080', '20210905');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2081', '20210911');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2082', '20210912');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2083', '20210918');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2084', '20210919');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2085', '20210921');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2086', '20210925');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2087', '20210926');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2088', '20211001');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2089', '20211002');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2090', '20211003');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2091', '20211004');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2092', '20211005');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2093', '20211006');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2094', '20211007');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2095', '20211016');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2096', '20211017');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2097', '20211023');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2098', '20211024');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2099', '20211030');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2100', '20211031');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2101', '20211106');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2102', '20211107');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2103', '20211113');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2104', '20211114');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2105', '20211120');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2106', '20211121');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2107', '20211127');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2108', '20211128');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2109', '20211204');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2110', '20211205');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2111', '20211211');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2112', '20211212');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2113', '20211218');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2114', '20211219');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2115', '20211225');
INSERT INTO `no_work_day` (`id`, `day`) VALUES ('2116', '20211226');

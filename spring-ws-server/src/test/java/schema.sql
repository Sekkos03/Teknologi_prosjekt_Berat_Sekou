CREATE TABLE user (
                      UserID INTEGER PRIMARY KEY,
                      UserName TEXT,
                      Password TEXT
);

DROP TABLE IF EXISTS `user_account`;

CREATE TABLE `user_account` (
                                `UserID` int(10)  NOT NULL,
                                `UserName` varchar(255) DEFAULT NULL,
                                `Gender` char(1) NOT NULL DEFAULT '',
                                `Image` longblob,
                                `ImageString` varchar(255) DEFAULT '',
                                `Status` char(1) NOT NULL DEFAULT '1',
                                PRIMARY KEY (`UserID`),
                                CONSTRAINT `user_account_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
);


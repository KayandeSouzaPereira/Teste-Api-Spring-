CREATE DATABASE `kayan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `api` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NomeCompleto` varchar(500) NOT NULL,
  `Descricao` text NOT NULL,
  `DataDeCriacao` datetime NOT NULL,
  `DataDeAtualizacao` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

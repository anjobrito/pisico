/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.5-10.1.9-MariaDB : Database - pisico
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pisico` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pisico`;

/*Table structure for table `tb_agenda` */

DROP TABLE IF EXISTS `tb_agenda`;

CREATE TABLE `tb_agenda` (
  `id_agenda` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dt_agendamento` timestamp NULL DEFAULT NULL,
  `str_descricao` varchar(250) DEFAULT NULL,
  `str_status` varchar(1) DEFAULT 'A',
  `dt_cancelamento` timestamp NULL DEFAULT NULL,
  `id_convenio` int(10) unsigned DEFAULT NULL,
  `id_paciente` int(10) unsigned DEFAULT NULL,
  `id_status` int(10) unsigned DEFAULT NULL,
  `str_historico` longtext,
  `dt_atendimento` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_agenda`),
  KEY `id_convenio` (`id_convenio`),
  KEY `id_paciente` (`id_paciente`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `FK_tb_agenda` FOREIGN KEY (`id_convenio`) REFERENCES `tb_convenio` (`id_convenio`),
  CONSTRAINT `FK_tb_agenda_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `tb_paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tb_agenda_status` FOREIGN KEY (`id_status`) REFERENCES `tb_status` (`id_status`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

/*Data for the table `tb_agenda` */

insert  into `tb_agenda`(`id_agenda`,`dt_agendamento`,`str_descricao`,`str_status`,`dt_cancelamento`,`id_convenio`,`id_paciente`,`id_status`,`str_historico`,`dt_atendimento`) values (9,'2017-12-22 09:15:00','TESTE',NULL,NULL,2,1,NULL,NULL,NULL),(10,'2017-02-10 08:17:00','TESTE2',NULL,NULL,2,1,NULL,NULL,NULL),(11,'2017-10-28 11:00:00','TESTE',NULL,NULL,2,1,NULL,NULL,NULL),(12,'2017-10-27 03:22:00','plim',NULL,NULL,2,1,NULL,NULL,NULL),(13,'2017-10-27 03:25:00','TESTE',NULL,NULL,2,1,NULL,NULL,NULL),(14,'2017-11-11 09:23:00',' Paciente com possivel caso de delirio \nem massa',NULL,NULL,2,1,NULL,NULL,NULL),(15,'2017-11-15 09:00:00','TESTE',NULL,NULL,2,1,NULL,NULL,NULL),(16,'2017-11-14 01:00:00','TESTE',NULL,NULL,2,1,NULL,NULL,NULL),(17,'2017-11-13 17:00:00','TESTE',NULL,NULL,2,1,NULL,NULL,NULL),(18,'2017-11-13 12:30:00','TESTE',NULL,NULL,2,1,NULL,NULL,NULL);

/*Table structure for table `tb_banco` */

DROP TABLE IF EXISTS `tb_banco`;

CREATE TABLE `tb_banco` (
  `id_banco` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `str_descricao` int(10) unsigned DEFAULT NULL,
  `str_numero` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_banco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_banco` */

/*Table structure for table `tb_cidade` */

DROP TABLE IF EXISTS `tb_cidade`;

CREATE TABLE `tb_cidade` (
  `id_cidade` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tb_uf_id_uf` int(10) unsigned NOT NULL,
  `str_descricao` varchar(250) DEFAULT NULL,
  `str_cod_ibege` varchar(30) DEFAULT NULL,
  `str_cod_area` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id_cidade`),
  KEY `tb_cidade_FKIndex1` (`tb_uf_id_uf`),
  KEY `IFK_Rel_02` (`tb_uf_id_uf`),
  CONSTRAINT `tb_cidade_ibfk_1` FOREIGN KEY (`tb_uf_id_uf`) REFERENCES `tb_uf` (`id_uf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `tb_cidade` */

insert  into `tb_cidade`(`id_cidade`,`tb_uf_id_uf`,`str_descricao`,`str_cod_ibege`,`str_cod_area`) values (1,1,'CAMPINAS','3509502','019'),(2,1,'Valinho','3556206','019'),(3,3,'Padre Paraiso','3146305','039'),(4,1,'São Paulo','3550308','11'),(5,1,'Jundiai','3525904','11'),(6,2,'Resende','3905545','20'),(7,3,'Belo Horizonte','3945655','31'),(8,3,'Vespaziano','39675128','30'),(9,1,'Santo André','3949940','011');

/*Table structure for table `tb_conta` */

DROP TABLE IF EXISTS `tb_conta`;

CREATE TABLE `tb_conta` (
  `id_conta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tb_usuario_id_usuario` int(10) unsigned NOT NULL,
  `tb_banco_id_banco` int(10) unsigned NOT NULL,
  `str_agencia` varchar(200) DEFAULT NULL,
  `str_conta` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_conta`),
  KEY `tb_conta_FKIndex1` (`tb_banco_id_banco`),
  KEY `tb_conta_FKIndex2` (`tb_usuario_id_usuario`),
  KEY `IFK_Rel_01` (`tb_banco_id_banco`),
  KEY `IFK_Rel_10` (`tb_usuario_id_usuario`),
  CONSTRAINT `tb_conta_ibfk_1` FOREIGN KEY (`tb_banco_id_banco`) REFERENCES `tb_banco` (`id_banco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_conta_ibfk_2` FOREIGN KEY (`tb_usuario_id_usuario`) REFERENCES `tb_usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_conta` */

/*Table structure for table `tb_convenio` */

DROP TABLE IF EXISTS `tb_convenio`;

CREATE TABLE `tb_convenio` (
  `id_convenio` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `str_descricao` varchar(255) DEFAULT NULL,
  `str_status` varchar(1) DEFAULT NULL,
  `str_valor_hora` double(10,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_convenio`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `tb_convenio` */

insert  into `tb_convenio`(`id_convenio`,`str_descricao`,`str_status`,`str_valor_hora`) values (1,'UNIMED','A',140.00),(2,'AMIL','A',140.00),(3,'SAUDE BRADESCO','A',132.00),(4,'SULAMERICA','A',160.00),(5,'PARTICULAR',NULL,50.00);

/*Table structure for table `tb_paciente` */

DROP TABLE IF EXISTS `tb_paciente`;

CREATE TABLE `tb_paciente` (
  `id_paciente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tb_convenio_id_convenio` int(10) unsigned NOT NULL,
  `tb_cidade_id_cidade` int(10) unsigned NOT NULL,
  `str_numero` varchar(100) DEFAULT NULL,
  `str_nome` varchar(250) DEFAULT NULL,
  `str_nome_pai` varchar(250) DEFAULT NULL,
  `str_nome_mae` varchar(250) DEFAULT NULL,
  `str_endereco` varchar(250) DEFAULT NULL,
  `str_nro_casa` varchar(200) DEFAULT NULL,
  `str_rg` varchar(18) DEFAULT NULL,
  `str_cpf` varchar(18) DEFAULT NULL,
  `str_telefone` varchar(20) DEFAULT NULL,
  `str_cel` varchar(20) DEFAULT NULL,
  `str_email` varchar(250) DEFAULT NULL,
  `str_sexo` varchar(1) NOT NULL,
  `str_profissao` varchar(250) DEFAULT NULL,
  `int_idade_pai` int(6) DEFAULT NULL,
  `int_idade_mae` int(6) DEFAULT NULL,
  `dt_nasc` date DEFAULT NULL,
  `id_profissao_mae` int(11) DEFAULT NULL,
  `id_profissao_pai` int(11) DEFAULT NULL,
  `id_profeissao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_paciente`),
  KEY `tb_paciente_FKIndex1` (`tb_cidade_id_cidade`),
  KEY `tb_paciente_FKIndex2` (`tb_convenio_id_convenio`),
  KEY `IFK_Rel_03` (`tb_cidade_id_cidade`),
  KEY `IFK_Rel_04` (`tb_convenio_id_convenio`),
  KEY `FK_tb_paciente` (`id_profeissao`),
  KEY `FK_tb_paciente_mae` (`id_profissao_mae`),
  KEY `FK_tb_paciente_pai` (`id_profissao_pai`),
  CONSTRAINT `FK_tb_paciente` FOREIGN KEY (`id_profeissao`) REFERENCES `tb_profissao` (`id_profissao`),
  CONSTRAINT `FK_tb_paciente_mae` FOREIGN KEY (`id_profissao_mae`) REFERENCES `tb_profissao` (`id_profissao`),
  CONSTRAINT `FK_tb_paciente_pai` FOREIGN KEY (`id_profissao_pai`) REFERENCES `tb_profissao` (`id_profissao`),
  CONSTRAINT `tb_paciente_ibfk_1` FOREIGN KEY (`tb_cidade_id_cidade`) REFERENCES `tb_cidade` (`id_cidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_paciente_ibfk_2` FOREIGN KEY (`tb_convenio_id_convenio`) REFERENCES `tb_convenio` (`id_convenio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `tb_paciente` */

insert  into `tb_paciente`(`id_paciente`,`tb_convenio_id_convenio`,`tb_cidade_id_cidade`,`str_numero`,`str_nome`,`str_nome_pai`,`str_nome_mae`,`str_endereco`,`str_nro_casa`,`str_rg`,`str_cpf`,`str_telefone`,`str_cel`,`str_email`,`str_sexo`,`str_profissao`,`int_idade_pai`,`int_idade_mae`,`dt_nasc`,`id_profissao_mae`,`id_profissao_pai`,`id_profeissao`) values (1,2,1,'999','LAURO RIPETO','SERGIO ALCANTARA RIPETO','SILVIA LUCENA RIPETO','RUA 01','01','22.222.222-22','111.111.111-11','(099) 99999-9999','(099) 99999-9999','lauro@gmail.com','F',NULL,NULL,NULL,NULL,5,4,NULL);

/*Table structure for table `tb_perfil` */

DROP TABLE IF EXISTS `tb_perfil`;

CREATE TABLE `tb_perfil` (
  `id_perfil` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `str_descricao` varchar(255) DEFAULT NULL,
  `int_nive` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tb_perfil` */

insert  into `tb_perfil`(`id_perfil`,`str_descricao`,`int_nive`) values (3,'Administrador de Sistemas',1),(4,'Secretária',3),(5,'Pisicologo',2);

/*Table structure for table `tb_perfil_has_tb_usuario` */

DROP TABLE IF EXISTS `tb_perfil_has_tb_usuario`;

CREATE TABLE `tb_perfil_has_tb_usuario` (
  `tb_perfil_id_perfil` int(10) unsigned NOT NULL,
  `tb_usuario_id_usuario` int(10) unsigned NOT NULL,
  `id_perfilusuario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_perfilusuario`),
  KEY `tb_perfil_has_tb_usuario_FKIndex1` (`tb_perfil_id_perfil`),
  KEY `tb_perfil_has_tb_usuario_FKIndex2` (`tb_usuario_id_usuario`),
  KEY `IFK_Rel_07` (`tb_perfil_id_perfil`),
  KEY `IFK_Rel_08` (`tb_usuario_id_usuario`),
  CONSTRAINT `tb_perfil_has_tb_usuario_ibfk_1` FOREIGN KEY (`tb_perfil_id_perfil`) REFERENCES `tb_perfil` (`id_perfil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_perfil_has_tb_usuario_ibfk_2` FOREIGN KEY (`tb_usuario_id_usuario`) REFERENCES `tb_usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tb_perfil_has_tb_usuario` */

insert  into `tb_perfil_has_tb_usuario`(`tb_perfil_id_perfil`,`tb_usuario_id_usuario`,`id_perfilusuario`) values (3,1,1),(4,2,2),(5,3,3),(4,16,4);

/*Table structure for table `tb_profissao` */

DROP TABLE IF EXISTS `tb_profissao`;

CREATE TABLE `tb_profissao` (
  `id_profissao` int(11) NOT NULL AUTO_INCREMENT,
  `str_descricao` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_profissao`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `tb_profissao` */

insert  into `tb_profissao`(`id_profissao`,`str_descricao`) values (1,'ANALISTA DE SISTEMAS'),(2,'PROFESSORA'),(4,'PROFESSOR'),(5,'PEDREIRO'),(6,'CARPINTEIRO'),(7,'ZELADOR'),(8,'BANCARIO'),(9,'SOLDADOR'),(10,'DO LAR');

/*Table structure for table `tb_status` */

DROP TABLE IF EXISTS `tb_status`;

CREATE TABLE `tb_status` (
  `id_status` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `str_descricao` varchar(250) DEFAULT NULL,
  `dlb_valor` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tb_status` */

insert  into `tb_status`(`id_status`,`str_descricao`,`dlb_valor`) values (1,'PRESENÇA',1.00),(2,'FALTA REMUNERADA',2.00),(3,'XXXX',1.00);

/*Table structure for table `tb_uf` */

DROP TABLE IF EXISTS `tb_uf`;

CREATE TABLE `tb_uf` (
  `id_uf` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `str_descricao` varchar(250) DEFAULT NULL,
  `str_sigla` varchar(2) DEFAULT NULL,
  `str_cod_ibege` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_uf`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `tb_uf` */

insert  into `tb_uf`(`id_uf`,`str_descricao`,`str_sigla`,`str_cod_ibege`) values (1,'São Paulo','SP','3550308'),(2,'Rio de Janeiro','RJ','3304557'),(3,'Minas Gerais','MG','3106200'),(4,'Acre','AC','1200401'),(5,'Alagoas','AL','2704302'),(6,'Amazonas','AM','1302603'),(7,'Amapá','PA','1600303'),(8,'Parana','PR','4106902'),(9,'Céara','CE','2304400'),(10,'Rio Grande do Sul','RS','99999999'),(11,'Bahia','BA','8888888');

/*Table structure for table `tb_usuario` */

DROP TABLE IF EXISTS `tb_usuario`;

CREATE TABLE `tb_usuario` (
  `id_usuario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `str_nome` varchar(500) DEFAULT NULL,
  `str_usuario` varchar(50) DEFAULT NULL,
  `str_pwd` varchar(50) DEFAULT NULL,
  `dt_data_entrada` date DEFAULT NULL,
  `str_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `tb_usuario` */

insert  into `tb_usuario`(`id_usuario`,`str_nome`,`str_usuario`,`str_pwd`,`dt_data_entrada`,`str_status`) values (1,'ADMINISTRADOR DE SISTEMAS','ADMIN','ADMIN','2017-10-07',NULL),(2,'USUARIO PADRAO','123','555','2017-01-01',NULL),(3,'ANA LUCIA DE BRITO','ANA','123','2017-11-13',NULL),(16,'PAULO CESAR AUGUSTO','paulo','444','2017-11-13',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

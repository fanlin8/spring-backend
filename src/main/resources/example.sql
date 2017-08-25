create database if not exists db_example;
create user 'springuser'@'localhost' identified by 'ThePassword';
grant all on db_example.* to 'springuser'@'localhost';

USE db_example;
CREATE TABLE IF NOT EXISTS `articles` (
  `article_id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `category` varchar(100) NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
INSERT INTO `articles` (`article_id`, `title`, `category`) VALUES
	(1, 'Java Concurrency', 'Java'),
	(2, 'Hibernate HQL ', 'Hibernate'),
	(3, 'Spring MVC with Hibernate', 'Spring'); 
    
select * from articles;
SET NAMES utf8;

DROP DATABASE IF EXISTS listencode;
CREATE DATABASE listencode DEFAULT CHARSET utf8mb4;
USE listencode;

-- 听书资源表
DROP TABLE IF EXISTS books;
CREATE TABLE books (
    id          VARCHAR(20) PRIMARY KEY COMMENT 'id',
    name        VARCHAR(20) NOT NULL COMMENT '书名',
    author      VARCHAR(20) NOT NULL COMMENT '作者',
    description VARCHAR(200) COMMENT '简介'
) COMMENT '听书资源表';

-- 章节表
DROP TABLE IF EXISTS chapters;
CREATE TABLE chapters (
    id          VARCHAR(20) PRIMARY KEY COMMENT 'id',
    name        VARCHAR(20) NOT NULL COMMENT '章节名',
    audio_url   VARCHAR(200) NOT NULL COMMENT '音频地址'
) COMMENT '章节表';

-- 书和章节关系表
DROP TABLE IF EXISTS book_chapter_relation;
CREATE TABLE book_chapter_relation (
    id          VARCHAR(20) PRIMARY KEY COMMENT 'id',
    book_id     VARCHAR(20) NOT NULL COMMENT '书id', 
    chapter_id  VARCHAR(20) NOT NULL COMMENT '章节id',
    orderNumber VARCHAR(20) NOT NULL COMMENT '章节顺序'
) COMMENT '书和章节关系表';

INSERT INTO books(id, name, author, description) values(1, "遮天", "辰东", "仙路尽头谁为峰, 一见无始道成空");
INSERT INTO books(id, name, author, description) values(2, "凡人修仙传", "忘语", "杀人放火历飞羽，救死扶伤韩老魔");
INSERT INTO books(id, name, author, description) values(3, "求魔", "耳根", "我若成魔，佛奈我何");

INSERT INTO chapters(id, name, audio_url) values(1, "第一章 星空中的青铜巨棺", "/demo/url");
INSERT INTO chapters(id, name, audio_url) values(2, "第二章 素问", "/demo/url");
INSERT INTO chapters(id, name, audio_url) values(3, "第一章 山边小村", "/demo/url");
INSERT INTO chapters(id, name, audio_url) values(4, "第二章 青牛镇", "/demo/url");
INSERT INTO chapters(id, name, audio_url) values(5, "第三章 七玄门", "/demo/url");
INSERT INTO chapters(id, name, audio_url) values(6, "第一章 苏铭", "/demo/url");
INSERT INTO chapters(id, name, audio_url) values(7, "第二章 蛮启", "/demo/url");

INSERT INTO book_chapter_relation(id, book_id, chapter_id, orderNumber) values(1, 1, 1, 1);
INSERT INTO book_chapter_relation(id, book_id, chapter_id, orderNumber) values(2, 1, 2, 2);
INSERT INTO book_chapter_relation(id, book_id, chapter_id, orderNumber) values(3, 2, 3, 1);
INSERT INTO book_chapter_relation(id, book_id, chapter_id, orderNumber) values(4, 2, 4, 2);
INSERT INTO book_chapter_relation(id, book_id, chapter_id, orderNumber) values(5, 2, 5, 3);
INSERT INTO book_chapter_relation(id, book_id, chapter_id, orderNumber) values(6, 3, 6, 1);
INSERT INTO book_chapter_relation(id, book_id, chapter_id, orderNumber) values(7, 3, 7, 2);
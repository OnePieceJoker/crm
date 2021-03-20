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
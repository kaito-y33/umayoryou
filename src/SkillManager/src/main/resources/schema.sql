-- テーブルを削除
DROP TABLE IF EXISTS language_skill;
DROP TABLE IF EXISTS tool_skill;
DROP TABLE IF EXISTS language;
DROP TABLE IF EXISTS tool;
DROP TABLE IF EXISTS engineer_skill;
DROP TABLE IF EXISTS project_engineers;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS engineer;

-- Engineer Table
CREATE TABLE IF NOT EXISTS engineer (
    engineer_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    engineer_name VARCHAR(255) NOT NULL,
    position VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Project Table
CREATE TABLE IF NOT EXISTS project (
    project_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    project_name VARCHAR(255) NOT NULL,
    description TEXT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    working_start_time TIME,
    working_end_time TIME,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- PROJECT_ENGINEERS テーブル
CREATE TABLE IF NOT EXISTS  project_engineers (
    project_id BIGINT,
    engineer_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (project_id, engineer_id),
    FOREIGN KEY (project_id) REFERENCES project (project_id),
    FOREIGN KEY (engineer_id) REFERENCES engineer (engineer_id)
);

-- ENGINEER_SKILLS テーブル
CREATE TABLE IF NOT EXISTS  engineer_skill (
    engineer_skill_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    engineer_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (engineer_id) REFERENCES engineer (engineer_id)
);

-- LANGUAGE テーブル
CREATE TABLE IF NOT EXISTS  language (
    language_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    language_name VARCHAR(255) UNIQUE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- LANGUAGE_SKILL テーブル
CREATE TABLE IF NOT EXISTS  language_skill (
    language_skill_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    engineer_skill_id BIGINT,
    language_id BIGINT,
    level INTEGER,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (engineer_skill_id) REFERENCES engineer_skill (engineer_skill_id),
    FOREIGN KEY (language_id) REFERENCES language (language_id)
);

-- TOOL テーブル
CREATE TABLE IF NOT EXISTS  tool (
    tool_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tool_name VARCHAR(255) UNIQUE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- TOOL_SKILL テーブル
CREATE TABLE IF NOT EXISTS  tool_skill (
    tool_skill_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    engineer_skill_id BIGINT,
    tool_id BIGINT,
    level INTEGER,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (engineer_skill_id) REFERENCES engineer_skill (engineer_skill_id),
    FOREIGN KEY (tool_id) REFERENCES tool (tool_id)
);


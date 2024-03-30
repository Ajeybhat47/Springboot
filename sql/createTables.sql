DROP TABLE IF EXISTS bid;
DROP TABLE IF EXISTS auction;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE item (
    item_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(255) NOT NULL,
    description TEXT,
    initial_price DOUBLE NOT NULL,
    seller_id BIGINT NOT NULL,
    FOREIGN KEY (seller_id) REFERENCES user(user_id)
);

CREATE TABLE auction (
    auction_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    item_id BIGINT NOT NULL,
    base_price DOUBLE NOT NULL,
    status VARCHAR(255) NOT NULL,
    winner_id BIGINT,
    FOREIGN KEY (item_id) REFERENCES item(item_id),
    FOREIGN KEY (winner_id) REFERENCES user(user_id)
);

CREATE TABLE bid (
    bid_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    bidder_id BIGINT NOT NULL,
    bid_amount DOUBLE NOT NULL,
    bid_time DATETIME NOT NULL,
    auction_id BIGINT NOT NULL,
    FOREIGN KEY (bidder_id) REFERENCES user(user_id),
    FOREIGN KEY (auction_id) REFERENCES auction(auction_id)
);


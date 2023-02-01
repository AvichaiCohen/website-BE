DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_order;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS favourite_list;
DROP TABLE IF EXISTS order_list;
DROP TABLE IF EXISTS favourite;

CREATE TABLE user (
     id int(11) unsigned NOT NULL AUTO_INCREMENT,
     username varchar(20) NOT NULL DEFAULT '',
     password varchar(20) NOT NULL DEFAULT '',
     active tinyint(1) NOT NULL DEFAULT '1',
     first_name varchar(300) NOT NULL DEFAULT '',
     last_name varchar(300) NOT NULL DEFAULT '',
     email varchar(300) NOT NULL DEFAULT '',
     phone varchar(300) NOT NULL DEFAULT '',
     city varchar(300) NOT NULL DEFAULT '',
     country varchar(300) NOT NULL DEFAULT '',
     PRIMARY KEY (id)
);

CREATE TABLE user_order (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    username varchar(30) NOT NULL ,
    order_date date NOT NULL DEFAULT '',
    shipping_address varchar(300) NOT NULL DEFAULT '',
    total_price int(11) NOT NULL DEFAULT '',
    order_status varchar(300) NOT NULL DEFAULT 'TEMP',
    PRIMARY KEY (id),
    FOREIGN KEY (username) REFERENCES user(username)
);
	CREATE TABLE item (
    item_id int(11) unsigned NOT NULL AUTO_INCREMENT,
    title varchar(300) NOT NULL DEFAULT '',
    photo varchar(300) NOT NULL DEFAULT '',
    price int(11) NOT NULL,
    in_stock int(11) NOT NULL,
    PRIMARY KEY (item_id)
);
CREATE TABLE favourite (
    favourite_id int(11) unsigned NOT NULL AUTO_INCREMENT,
    username varchar(30) NOT NULL,
    PRIMARY KEY (favourite_id),
    FOREIGN KEY(username) REFERENCES user(username)
);
CREATE TABLE order_list (
    order_list_id int(20) unsigned NOT NULL AUTO_INCREMENT,
    username varchar(30) NOT NULL,
    item_id int(11) NOT NULL,
    quantity_of_item int(11) NOT NULL,
    FOREIGN KEY(item_id) REFERENCES item(item_id)
);
CREATE TABLE favourite_list (
    favourite_list_id int(11) unsigned NOT NULL AUTO_INCREMENT,
    username varchar(30) NOT NULL,
    item_id int(11) NOT NULL,
    quantity_of_item int(11) NOT NULL,
    PRIMARY KEY (favourite_list_id),
    FOREIGN KEY(item_id) REFERENCES item(item_id)
);

INSERT INTO item(title,photo,price,in_stock) VALUES
('Basketball','https://upload.wikimedia.org/wikipedia/commons/7/7a/Basketball.png',50,134),
('Football','https://www.si.com/.image/ar_4:3%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTkxMTk2ODg5NjI0MjI1MDAz/al-rihla.jpg',20,13),
('Chair','https://www.dan-form.com/media/d5iiuemc/arch-chair-pebble-green-boucle-fabric-with-black-metal-legs-100205105-01-main.png?width=522&mode=crop&heightratio=1',30,48),
('Desk','https://media.bonaldo.com/wp-content/uploads/2020/05/28165048/bonaldo-tavolo-bigtable-stilllife-1.jpg',40,382),
('Computer','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoag0ZFNQ4ASL6e4KZfEH7tXoiB043B9fIoQ&usqp=CAU',73,272),
('Washing Machine','https://media.miele.com/images/2000018/200001857/20000185777.png?impolicy=z-boxed&d=1500',286,290),
('Closet','https://www.ace.co.il/media/catalog/product/cache/230be187dd2874b1367221e12e8f5484/i/t/item_picture_5700497-680604949.jpg',372,123),
('Bed','https://cdn.shopify.com/s/files/1/0225/2528/0331/products/sydney_bed_natural_king-queen_1_2000x.jpg?v=1587146049',382,293),
('Oven','https://kleenmaid.com.au/wp-content/uploads/2021/08/OFS9021_J12415-Kleenmaid-Website-DropShadow-Images-Aug2021_01-1024x1024.jpg',472,232),
('Microwave','https://www.sencor.com/Sencor/media/content/products/36d0dca1-c410-437e-9801-edce0f345194.jpg',80,389),

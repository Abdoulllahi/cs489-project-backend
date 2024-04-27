-- Populate customers
INSERT INTO customers (first_name, last_name, email, password, username, phone)
VALUES
    ('John', 'Doe', 'john@example.com', '123456', 'johndoe', '123-456-7890'),
    ('Jane', 'Smith', 'jane@example.com', '654321', 'janesmith', '987-654-3210');

-- Populate DVDs
INSERT INTO dvds (genre, scan_code, title)
VALUES
    ('Action', 'A001', 'The Matrix'),
    ('Comedy', 'C002', 'Superbad'),
    ('Drama', 'D003', 'The Shawshank Redemption'),
    ('Science Fiction', 'SF004', 'Inception');

-- Populate subscriptions
INSERT INTO subscriptions (name, number_ofdvdper_month, number_ofdvdat_home, price_per_month)
VALUES
    ('Basic', 2, 1, 9.99),
    ('Standard', 4, 2, 19.99),
    ('Premium', 6, 3, 29.99);

-- Populate customer subscriptions
INSERT INTO customer_subscription (customer_id, subscription_id)
VALUES
    (1, 1),
    (2, 2);

-- Populate DVDs at home
INSERT INTO dvds_at_home (customer_id, dvd_id)
VALUES
    (1, 1),
    (2, 3);

-- Populate requested DVDs
INSERT INTO requested_dvds (customer_id, dvd_id)
VALUES
    (1, 2),
    (2, 4);

-- Populate watch list
INSERT INTO watch_list (customer_id, dvd_id)
VALUES
    (1, 3),
    (2, 1);

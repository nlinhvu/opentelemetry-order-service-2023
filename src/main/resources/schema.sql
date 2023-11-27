CREATE SCHEMA IF NOT EXISTS orders;

CREATE TABLE orders.orders (
        id int8 NOT NULL,
        customer_id int8 NULL,
        order_date timestamptz(6) NULL,
        total_amount numeric(38, 2) NULL,
        CONSTRAINT orders_pkey PRIMARY KEY (id)
);
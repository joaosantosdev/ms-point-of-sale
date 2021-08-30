DROP VIEW IF EXISTS view_quantity_total_product;
CREATE OR REPLACE VIEW view_quantity_total_product AS
SELECT 
mp.product_id
,COALESCE(SUM(
CASE mp.type_operation
WHEN 1 THEN -1 * mp.quantity
ELSE mp.quantity
END
))::BIGINT AS quantity_total
FROM movement_product mp
GROUP BY
mp.product_id;
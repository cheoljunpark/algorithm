SELECT
    product_code,
    price* SUM(sales_amount) AS sales
FROM product a
    JOIN offline_sale b
    ON a.product_id = b.product_id
GROUP BY
    product_code
ORDER BY
    sales DESC,
    product_code ASC;
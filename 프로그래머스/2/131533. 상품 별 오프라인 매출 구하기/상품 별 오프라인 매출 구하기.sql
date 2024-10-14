SELECT 
    product_code,
    price*SUM(sales_amount) AS sales
FROM PRODUCT AS p INNER JOIN OFFLINE_SALE AS o
    ON
    p.product_id = o.product_id
GROUP BY product_code
ORDER BY
    sales DESC,
    product_code ASC;
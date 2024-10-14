SELECT 
    category, SUM(sales) AS total_sales
FROM BOOK INNER JOIN BOOK_SALES ON BOOK.book_id = BOOK_SALES.book_id
WHERE YEAR(BOOK_SALES.sales_date) = '2022' AND MONTH(BOOK_SALES.sales_date) = '1'
GROUP BY BOOK.category
ORDER BY category ASC;
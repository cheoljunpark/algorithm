SELECT
    ROUND(AVG(length),2) AS average_length
FROM
    (
        SELECT 
            CASE
                WHEN length IS NULL THEN 10
                WHEN length <= 10 THEN 10
                ELSE length
            END AS length
        FROM fish_info
    ) as f
SELECT 
    MONTH(start_date) AS MONTH,
    car_id,
    COUNT(*) AS records
    # *
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE MONTH(start_date) IN ('8','9','10')
    AND car_id IN (
        SELECT car_id
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE MONTH(start_date) IN ('8','9','10')
        GROUP BY car_id
        HAVING COUNT(*) >=5
    )
GROUP BY car_id, MONTH(start_date)
HAVING records >= 1
ORDER BY 
    month ASC,
    car_id DESC;
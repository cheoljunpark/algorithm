SELECT
    YEAR(DIFFERENTIATION_DATE) AS year,
    (
        SELECT MAX(size_of_colony)
        FROM ECOLI_DATA
        WHERE YEAR(DIFFERENTIATION_DATE) = year
    ) - size_of_colony AS year_dev,
    id
FROM
    ECOLI_DATA
ORDER BY
    year ASC,
    year_dev ASC;
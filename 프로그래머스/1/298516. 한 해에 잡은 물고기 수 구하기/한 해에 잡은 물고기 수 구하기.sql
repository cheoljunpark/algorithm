SELECT
    COUNT(*) AS fish_count
FROM
    FISH_INFO
WHERE
    YEAR(time) = '2021'
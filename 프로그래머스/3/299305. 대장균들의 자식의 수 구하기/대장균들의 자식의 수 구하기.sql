SELECT P.ID AS ID,
       COUNT(C.PARENT_ID) AS CHILD_COUNT
FROM ECOLI_DATA P
LEFT JOIN ECOLI_DATA C
  ON P.ID = C.PARENT_ID
GROUP BY P.ID
ORDER BY P.ID ASC;

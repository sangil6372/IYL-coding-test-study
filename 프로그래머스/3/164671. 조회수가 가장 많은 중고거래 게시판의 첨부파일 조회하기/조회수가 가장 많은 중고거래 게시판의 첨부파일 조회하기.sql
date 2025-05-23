# WS 는 WITH SEPARATOR 을 의미 WS 키보드 한글 위치로 -> ㅈㄴ
# ㅈㄴ분리하고 싶을 때 사용
SELECT CONCAT_WS('/', '/home', 'grep', 'src', BOARD_ID, CONCAT(FILE_ID, FILE_NAME, FILE_EXT)) AS FILE_PATH
FROM USED_GOODS_FILE 
WHERE BOARD_ID = ( # 단일 값 반환하는 경우 IS 대신 = 를 사용
    SELECT BOARD_ID 
    FROM USED_GOODS_BOARD
    ORDER BY VIEWS DESC
    LIMIT 1
)
ORDER BY FILE_ID DESC

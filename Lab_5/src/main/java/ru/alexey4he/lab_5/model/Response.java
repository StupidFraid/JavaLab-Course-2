package ru.alexey4he.lab_5.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    /***
     * Индвидуальный идентификатор сообщения
     */
    private String uid;
    /***
     * Индвидуальный идентификатор операции
     */
    private String operationUid;
    /***
     * Время формирования ответа
     */
    private String systemTime;
    /***
     * Статус обработки запроса
     */
    private Codes code;
    /***
     * Премия получаемая сотрудником
     */
    private Double bonus;
    /***
     * Код ошибки
     */
    private ErrorCodes errorCode;
    /***
     * Текстовое сообщение об ошибке
     */
    private ErrorMessages errorMessage;

}

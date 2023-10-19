package ru.alexey4he.lab_5.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    /***
     * Уникальный идентификатор сообщения
     */
    @NotBlank
    @Size(max = 32)
    private String uid;
//  Validation, 32 char
    /***
     * Уникальный идентификатор операции
     */
    @NotBlank
    @Size(max = 32)
    private String operationUid;
    /***
     * Имя системы которая отправила сообщение
     */
    private SystemName systemName;
    /***
     * Время получения запроса
     */
    private String systemTime;
    /***
     * Источник получения запроса
     */
    private String source;
    /***
     * Позиция сотрудника для расчета премии
     */
    private Position position;
    /***
     * Зарплата сотрудника
     */
    private Double salary;
    /***
     * Индивидуальный бонус сотрудника
     */
    private Double bonus;
    /***
     * Количество отработанных дней сотрудником в этом году
     */
    private Integer workDays;
    /***
     * Незивестный параметр
     */
    @Range(min = 1, max = 100000)
    private int communicationId;
    /***
     * Незивестный параметр
     */
    private int templateId;
    /***
     * Незивестный параметр
     */
    private int productCode;
    /***
     * Незивестный параметр
     */
    private int smsCode;

    @Override
    public String toString(){
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                ", bonus=" + bonus + '\'' +
                ", workDays=" + workDays + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                "}";
    }
}

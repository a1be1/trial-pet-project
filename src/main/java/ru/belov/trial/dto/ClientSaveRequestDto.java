package ru.belov.trial.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.belov.trial.constant.ClientType;
import ru.belov.trial.constant.ExceptionMessage;
import ru.belov.trial.constant.Language;
import ru.belov.trial.infrastructure.LocalizedString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспорт для создания клиента")
public class ClientSaveRequestDto extends CommonDto {

    @NotNull(message = ExceptionMessage.CLIENT_ACTIVE_FLAG_IS_NULL)
    @Schema(description = "Флаг активности клиента", example = "true", required = true)
    private boolean active;

    @NotNull(message = ExceptionMessage.CLIENT_NAME_IS_NULL)
    @NotEmpty(message = ExceptionMessage.CLIENT_NAME_IS_EMPTY)
    @Schema(description = "Наименование клиента", example = "Петр", required = true)
    private LocalizedString name;

    @Schema(description = "Список UUID привязанных методов оплаты",
            example = "[ \"a1adc05a-d47d-4397-bc69-2a938a3907ce\", \"7cb0a38c-4bfd-438c-a5ce-4882ecb6248d\"]")
    private List<UUID> paymentMethodUuidList;

    @NotNull(message = ExceptionMessage.CLIENT_CITY_CODE_IS_NULL)
    @NotEmpty(message = ExceptionMessage.CLIENT_CITY_CODE_IS_EMPTY)
    @Schema(description = "Код города", example = "1", required = true)
    private String cityCode;

    @NotNull(message = ExceptionMessage.CLIENT_TYPE_IS_NULL)
    @Schema(description = "Тип клиента", example = "UR", required = true, allowableValues = "UR, FIZ")
    private ClientType clientType;

    @NotNull(message = ExceptionMessage.CLIENT_PHONE_IS_NULL)
    @NotEmpty(message = ExceptionMessage.CLIENT_PHONE_IS_EMPTY)
    @Pattern(message = ExceptionMessage.CLIENT_PHONE_INVALID, regexp = "^\\d{11}$")
    @Schema(description = "Номер телефона", example = "89134445566", required = true, minLength = 11, maxLength = 11)
    private String phoneNumber;
}

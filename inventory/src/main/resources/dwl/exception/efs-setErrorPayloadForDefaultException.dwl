%dw 1.0
%output application/json encoding="UTF-8", skipNullOn="everywhere"
---
{
	message: flowVars.statusCode,
	internalMessage: flowVars.errorMessage
}
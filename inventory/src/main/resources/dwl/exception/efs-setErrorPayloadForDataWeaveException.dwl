%dw 1.0
%output application/json encoding="UTF-8", skipNullOn="everywhere"
---
{
	message: 'ERROR',
	internalMessage: flowVars.errorMessage,
	status: flowVars.statusCode
}
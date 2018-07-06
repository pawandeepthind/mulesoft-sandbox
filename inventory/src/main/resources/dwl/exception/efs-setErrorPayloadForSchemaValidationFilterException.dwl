%dw 1.0
				%output application/json encoding="UTF-8", skipNullOn="everywhere"
				---
				{
					code: flowVars.errorResponseCode,
					severity: 'ERROR',
					message: 'SCHEMA_VALIDATION_FILTER_ERROR',
					internalMessage: flowVars.errorMessage,
					status: ''					
				}
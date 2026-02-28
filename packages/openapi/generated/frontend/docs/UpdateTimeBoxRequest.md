# UpdateTimeBoxRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**title** | **string** |  | [optional] [default to undefined]
**description** | **string** |  | [optional] [default to undefined]
**startAt** | **string** |  | [optional] [default to undefined]
**endAt** | **string** |  | [optional] [default to undefined]
**status** | [**TimeBoxStatus**](TimeBoxStatus.md) |  | [optional] [default to undefined]
**priority** | [**TimeBoxPriority**](TimeBoxPriority.md) |  | [optional] [default to undefined]
**tagIds** | **Array&lt;string&gt;** |  | [optional] [default to undefined]

## Example

```typescript
import { UpdateTimeBoxRequest } from './api';

const instance: UpdateTimeBoxRequest = {
    title,
    description,
    startAt,
    endAt,
    status,
    priority,
    tagIds,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

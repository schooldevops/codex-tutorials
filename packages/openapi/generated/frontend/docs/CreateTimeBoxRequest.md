# CreateTimeBoxRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**title** | **string** |  | [default to undefined]
**description** | **string** |  | [optional] [default to undefined]
**startAt** | **string** |  | [default to undefined]
**endAt** | **string** |  | [default to undefined]
**priority** | [**TimeBoxPriority**](TimeBoxPriority.md) |  | [default to undefined]
**tagIds** | **Array&lt;string&gt;** |  | [optional] [default to undefined]

## Example

```typescript
import { CreateTimeBoxRequest } from './api';

const instance: CreateTimeBoxRequest = {
    title,
    description,
    startAt,
    endAt,
    priority,
    tagIds,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

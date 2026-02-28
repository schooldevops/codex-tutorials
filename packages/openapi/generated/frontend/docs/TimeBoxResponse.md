# TimeBoxResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**userId** | **string** |  | [optional] [default to undefined]
**title** | **string** |  | [default to undefined]
**description** | **string** |  | [optional] [default to undefined]
**startAt** | **string** |  | [default to undefined]
**endAt** | **string** |  | [default to undefined]
**status** | [**TimeBoxStatus**](TimeBoxStatus.md) |  | [default to undefined]
**priority** | [**TimeBoxPriority**](TimeBoxPriority.md) |  | [default to undefined]
**completedAt** | **string** |  | [optional] [default to undefined]
**tags** | [**Array&lt;TagResponse&gt;**](TagResponse.md) |  | [optional] [default to undefined]
**createdAt** | **string** |  | [default to undefined]
**updatedAt** | **string** |  | [default to undefined]

## Example

```typescript
import { TimeBoxResponse } from './api';

const instance: TimeBoxResponse = {
    id,
    userId,
    title,
    description,
    startAt,
    endAt,
    status,
    priority,
    completedAt,
    tags,
    createdAt,
    updatedAt,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

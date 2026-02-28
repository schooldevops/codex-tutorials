# TimeBoxesApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createTimeBox**](#createtimebox) | **POST** /api/v1/time-boxes | Create a time-box|
|[**deleteTimeBox**](#deletetimebox) | **DELETE** /api/v1/time-boxes/{id} | Delete time-box|
|[**getTimeBox**](#gettimebox) | **GET** /api/v1/time-boxes/{id} | Get time-box by id|
|[**listTimeBoxes**](#listtimeboxes) | **GET** /api/v1/time-boxes | List time-boxes|
|[**updateTimeBox**](#updatetimebox) | **PATCH** /api/v1/time-boxes/{id} | Update time-box partially|

# **createTimeBox**
> TimeBoxResponse createTimeBox(createTimeBoxRequest)


### Example

```typescript
import {
    TimeBoxesApi,
    Configuration,
    CreateTimeBoxRequest
} from './api';

const configuration = new Configuration();
const apiInstance = new TimeBoxesApi(configuration);

let createTimeBoxRequest: CreateTimeBoxRequest; //

const { status, data } = await apiInstance.createTimeBox(
    createTimeBoxRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createTimeBoxRequest** | **CreateTimeBoxRequest**|  | |


### Return type

**TimeBoxResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**201** | Created |  -  |
|**0** | Error |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteTimeBox**
> deleteTimeBox()


### Example

```typescript
import {
    TimeBoxesApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new TimeBoxesApi(configuration);

let id: string; // (default to undefined)

const { status, data } = await apiInstance.deleteTimeBox(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] |  | defaults to undefined|


### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**204** | No Content |  -  |
|**0** | Error |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTimeBox**
> TimeBoxResponse getTimeBox()


### Example

```typescript
import {
    TimeBoxesApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new TimeBoxesApi(configuration);

let id: string; // (default to undefined)

const { status, data } = await apiInstance.getTimeBox(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] |  | defaults to undefined|


### Return type

**TimeBoxResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |
|**0** | Error |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listTimeBoxes**
> TimeBoxListResponse listTimeBoxes()


### Example

```typescript
import {
    TimeBoxesApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new TimeBoxesApi(configuration);

let date: string; // (optional) (default to undefined)
let from: string; // (optional) (default to undefined)
let to: string; // (optional) (default to undefined)
let status: TimeBoxStatus; // (optional) (default to undefined)
let tagId: string; // (optional) (default to undefined)
let page: number; // (optional) (default to 0)
let size: number; // (optional) (default to 20)

const { status, data } = await apiInstance.listTimeBoxes(
    date,
    from,
    to,
    status,
    tagId,
    page,
    size
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **date** | [**string**] |  | (optional) defaults to undefined|
| **from** | [**string**] |  | (optional) defaults to undefined|
| **to** | [**string**] |  | (optional) defaults to undefined|
| **status** | **TimeBoxStatus** |  | (optional) defaults to undefined|
| **tagId** | [**string**] |  | (optional) defaults to undefined|
| **page** | [**number**] |  | (optional) defaults to 0|
| **size** | [**number**] |  | (optional) defaults to 20|


### Return type

**TimeBoxListResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |
|**0** | Error |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateTimeBox**
> TimeBoxResponse updateTimeBox(updateTimeBoxRequest)


### Example

```typescript
import {
    TimeBoxesApi,
    Configuration,
    UpdateTimeBoxRequest
} from './api';

const configuration = new Configuration();
const apiInstance = new TimeBoxesApi(configuration);

let id: string; // (default to undefined)
let updateTimeBoxRequest: UpdateTimeBoxRequest; //

const { status, data } = await apiInstance.updateTimeBox(
    id,
    updateTimeBoxRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateTimeBoxRequest** | **UpdateTimeBoxRequest**|  | |
| **id** | [**string**] |  | defaults to undefined|


### Return type

**TimeBoxResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |
|**0** | Error |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


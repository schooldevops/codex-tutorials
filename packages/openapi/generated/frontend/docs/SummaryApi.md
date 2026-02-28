# SummaryApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**getDailySummary**](#getdailysummary) | **GET** /api/v1/summary/daily | Daily summary|

# **getDailySummary**
> DailySummaryResponse getDailySummary()


### Example

```typescript
import {
    SummaryApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new SummaryApi(configuration);

let date: string; // (default to undefined)

const { status, data } = await apiInstance.getDailySummary(
    date
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **date** | [**string**] |  | defaults to undefined|


### Return type

**DailySummaryResponse**

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


import {
  SummaryApi,
  TagsApi,
  TimeBoxesApi,
} from "../../../../../packages/openapi/generated/frontend";
import { apiConfiguration } from "./config";

export const timeBoxesApi = new TimeBoxesApi(apiConfiguration);
export const tagsApi = new TagsApi(apiConfiguration);
export const summaryApi = new SummaryApi(apiConfiguration);

import { Configuration } from "../../../../../packages/openapi/generated/frontend";

const defaultBasePath = "http://localhost:8080";

export const apiBasePath =
  process.env.NEXT_PUBLIC_API_BASE_URL?.trim() || defaultBasePath;

export const apiConfiguration = new Configuration({
  basePath: apiBasePath,
});

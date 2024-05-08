import axios from 'axios';
import {SERVICE_URL} from "./url.ts";

export const formatXml = async (params: string): Promise<string | null> => {
    const result = await axios.post(`${SERVICE_URL.FORMAT_XML_URL}`, params,{
        headers: {
            'Content-Type': 'text/plain',
        },
    });
    return result.data;
};

export const compressXml = async (params: string): Promise<string | null> => {
    const result = await axios.post(`${SERVICE_URL.COMPRESS_XML_URL}`, params);
    return result.data;
};
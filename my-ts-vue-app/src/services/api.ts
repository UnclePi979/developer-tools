import axios, { AxiosError } from 'axios';

export async function formatXml(xml: string): Promise<string | null> {
    try {
        const response = await axios.post('http://localhost:8082/api/xml/format', xml, {
            headers: {
                'Content-Type': 'text/plain',
            },
        });
        return response.data;
    } catch (error) {
        const typedError = error as AxiosError;
        console.error(typedError);
        return null;
    }
}


export async function compressXml(xml: string): Promise<string | null> {
    try {
        const response = await axios.post('http://localhost:8082/api/xml/compress', xml, {
            headers: {
                'Content-Type': 'text/plain',
            },
        });
        return response.data;
    } catch (error) {
        const typedError = error as AxiosError;
        console.error(typedError);
        return null;
    }
}
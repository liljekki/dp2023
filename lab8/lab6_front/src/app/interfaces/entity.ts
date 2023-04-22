import { ElementLinks } from "./rest.interfaces/elem_links";
export interface Entity {
    id:number;
    name: string
    description: string;
    img: string;
    _links?:ElementLinks;
}

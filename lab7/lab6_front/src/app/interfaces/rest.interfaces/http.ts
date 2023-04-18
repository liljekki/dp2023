import { Entity } from "../entity";
import { Page } from "./page";
import { RootLinks } from "./root_links";

export interface Http {
    _embedded: {
      entities: Entity[];
    };
    _links: RootLinks;
    page: Page;
}
  
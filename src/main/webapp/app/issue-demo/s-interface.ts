import { Observable } from 'rxjs';

export interface SInterface {
  get(id: number): Observable<string>;
}

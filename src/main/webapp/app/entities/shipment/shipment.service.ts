import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IShipment } from 'app/shared/model/shipment.model';

type EntityResponseType = HttpResponse<IShipment>;
type EntityArrayResponseType = HttpResponse<IShipment[]>;

@Injectable({ providedIn: 'root' })
export class ShipmentService {
  public resourceUrl = SERVER_API_URL + 'api/shipments';

  constructor(protected http: HttpClient) {}

  create(shipment: IShipment): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(shipment);
    return this.http
      .post<IShipment>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(shipment: IShipment): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(shipment);
    return this.http
      .put<IShipment>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IShipment>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IShipment[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(shipment: IShipment): IShipment {
    const copy: IShipment = Object.assign({}, shipment, {
      shippedAt: shipment.shippedAt && shipment.shippedAt.isValid() ? shipment.shippedAt.toJSON() : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.shippedAt = res.body.shippedAt ? moment(res.body.shippedAt) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((shipment: IShipment) => {
        shipment.shippedAt = shipment.shippedAt ? moment(shipment.shippedAt) : undefined;
      });
    }
    return res;
  }
}

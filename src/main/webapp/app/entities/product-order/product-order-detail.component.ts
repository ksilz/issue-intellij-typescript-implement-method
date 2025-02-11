import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IProductOrder } from 'app/shared/model/product-order.model';

@Component({
  selector: 'bpf-product-order-detail',
  templateUrl: './product-order-detail.component.html',
})
export class ProductOrderDetailComponent implements OnInit {
  productOrder: IProductOrder | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ productOrder }) => (this.productOrder = productOrder));
  }

  previousState(): void {
    window.history.back();
  }
}

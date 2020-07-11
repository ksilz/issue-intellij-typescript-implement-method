import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { SimpleShopTestModule } from '../../../test.module';
import { ShoppingOrderDetailComponent } from 'app/entities/shopping-order/shopping-order-detail.component';
import { ShoppingOrder } from 'app/shared/model/shopping-order.model';

describe('Component Tests', () => {
  describe('ShoppingOrder Management Detail Component', () => {
    let comp: ShoppingOrderDetailComponent;
    let fixture: ComponentFixture<ShoppingOrderDetailComponent>;
    const route = ({ data: of({ shoppingOrder: new ShoppingOrder(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [SimpleShopTestModule],
        declarations: [ShoppingOrderDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(ShoppingOrderDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ShoppingOrderDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load shoppingOrder on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.shoppingOrder).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});

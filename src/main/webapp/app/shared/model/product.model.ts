import { IProductOrder } from 'app/shared/model/product-order.model';
import { ProductCategory } from 'app/shared/model/enumerations/product-category.model';

export interface IProduct {
  id?: number;
  name?: string;
  price?: number;
  description?: any;
  pictureContentType?: string;
  picture?: any;
  specificationContentType?: string;
  specification?: any;
  category?: ProductCategory;
  inventory?: number;
  orders?: IProductOrder[];
}

export class Product implements IProduct {
  constructor(
    public id?: number,
    public name?: string,
    public price?: number,
    public description?: any,
    public pictureContentType?: string,
    public picture?: any,
    public specificationContentType?: string,
    public specification?: any,
    public category?: ProductCategory,
    public inventory?: number,
    public orders?: IProductOrder[]
  ) {}
}

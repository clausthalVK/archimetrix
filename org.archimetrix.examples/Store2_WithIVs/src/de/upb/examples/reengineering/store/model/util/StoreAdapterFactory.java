/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.upb.examples.reengineering.store.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import de.upb.examples.reengineering.store.model.*;


/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.upb.examples.reengineering.store.model.StorePackage
 * @generated
 */
public class StoreAdapterFactory extends AdapterFactoryImpl
{
   /**
    * The cached model package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected static StorePackage modelPackage;

   /**
    * Creates an instance of the adapter factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public StoreAdapterFactory()
   {
      if (modelPackage == null)
      {
         modelPackage = StorePackage.eINSTANCE;
      }
   }

   /**
    * Returns whether this factory is applicable for the type of the object.
    * <!-- begin-user-doc -->
    * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
    * <!-- end-user-doc -->
    * @return whether this factory is applicable for the type of the object.
    * @generated
    */
   @Override
   public boolean isFactoryForType(Object object)
   {
      if (object == modelPackage)
      {
         return true;
      }
      if (object instanceof EObject)
      {
         return ((EObject)object).eClass().getEPackage() == modelPackage;
      }
      return false;
   }

   /**
    * The switch that delegates to the <code>createXXX</code> methods.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected StoreSwitch<Adapter> modelSwitch =
      new StoreSwitch<Adapter>()
      {
         @Override
         public Adapter caseProduct(Product object)
         {
            return createProductAdapter();
         }
         @Override
         public Adapter caseCustomer(Customer object)
         {
            return createCustomerAdapter();
         }
         @Override
         public Adapter caseProducer(Producer object)
         {
            return createProducerAdapter();
         }
         @Override
         public Adapter caseStore(Store object)
         {
            return createStoreAdapter();
         }
         @Override
         public Adapter caseBook(Book object)
         {
            return createBookAdapter();
         }
         @Override
         public Adapter caseDVD(DVD object)
         {
            return createDVDAdapter();
         }
         @Override
         public Adapter caseWishlist(Wishlist object)
         {
            return createWishlistAdapter();
         }
         @Override
         public Adapter caseSeller(Seller object)
         {
            return createSellerAdapter();
         }
         @Override
         public Adapter defaultCase(EObject object)
         {
            return createEObjectAdapter();
         }
      };

   /**
    * Creates an adapter for the <code>target</code>.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param target the object to adapt.
    * @return the adapter for the <code>target</code>.
    * @generated
    */
   @Override
   public Adapter createAdapter(Notifier target)
   {
      return modelSwitch.doSwitch((EObject)target);
   }


   /**
    * Creates a new adapter for an object of class '{@link de.upb.examples.reengineering.store.model.Product <em>Product</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see de.upb.examples.reengineering.store.model.Product
    * @generated
    */
   public Adapter createProductAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link de.upb.examples.reengineering.store.model.Customer <em>Customer</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see de.upb.examples.reengineering.store.model.Customer
    * @generated
    */
   public Adapter createCustomerAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link de.upb.examples.reengineering.store.model.Producer <em>Producer</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see de.upb.examples.reengineering.store.model.Producer
    * @generated
    */
   public Adapter createProducerAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link de.upb.examples.reengineering.store.model.Store <em>Store</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see de.upb.examples.reengineering.store.model.Store
    * @generated
    */
   public Adapter createStoreAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link de.upb.examples.reengineering.store.model.Book <em>Book</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see de.upb.examples.reengineering.store.model.Book
    * @generated
    */
   public Adapter createBookAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link de.upb.examples.reengineering.store.model.DVD <em>DVD</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see de.upb.examples.reengineering.store.model.DVD
    * @generated
    */
   public Adapter createDVDAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link de.upb.examples.reengineering.store.model.Wishlist <em>Wishlist</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see de.upb.examples.reengineering.store.model.Wishlist
    * @generated
    */
   public Adapter createWishlistAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link de.upb.examples.reengineering.store.model.Seller <em>Seller</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see de.upb.examples.reengineering.store.model.Seller
    * @generated
    */
   public Adapter createSellerAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for the default case.
    * <!-- begin-user-doc -->
    * This default implementation returns null.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @generated
    */
   public Adapter createEObjectAdapter()
   {
      return null;
   }

} //StoreAdapterFactory

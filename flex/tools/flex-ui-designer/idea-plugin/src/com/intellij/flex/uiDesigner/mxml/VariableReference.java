package com.intellij.flex.uiDesigner.mxml;

import com.intellij.flex.uiDesigner.InvalidPropertyException;
import com.intellij.flex.uiDesigner.io.PrimitiveAmfOutputStream;
import com.intellij.lang.javascript.psi.JSVariable;

public class VariableReference implements ValueReference {
  private int reference = 0;

  private final JSVariable variable;

  public VariableReference(JSVariable variable) {
    this.variable = variable;
  }

  @Override
  public void write(PrimitiveAmfOutputStream out, BaseWriter writer, ValueReferenceResolver valueReferenceResolver)
    throws InvalidPropertyException {
    if (reference == 0) {
      out.writeUInt29(0);
    }
    else if (reference == -1) {
      reference = writer.allocateAbsoluteStaticObjectId() + 1;
      out.writeUInt29(reference << 1);
    }
    else {
      out.writeUInt29(reference << 1 | 1);
      return;
    }

    ExpressionBinding.writeJSVariable(variable, out, writer, valueReferenceResolver);
  }

  public void markAsMultipleReferred() {
    reference = -1;
  }
}

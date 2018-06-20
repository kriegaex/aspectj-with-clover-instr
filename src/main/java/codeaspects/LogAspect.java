/**
 * Copyright 2002-2018 MULTICERT S.A.
 * All rights reserved.
 *
 * This source is provided for inspection purposes and recompilation only,
 * unless specified differently in a contract with MULTICERT S.A.. This
 * source has to be kept in strict confidence and must not be disclosed to any
 * third party under any circumstances. Redistribution in source and binary
 * forms, with or without modification, are NOT permitted in any case!
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * Should any term or condition of this representation be deemed invalid or
 * inefficient, it will not affect the validity and efficiency of the remainder
 * of the Contract.
 */
package codeaspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {

    private static final Log LOG = LogFactory.getLog( LogAspect.class );


    @SuppressWarnings( "unused" )
    @Pointcut( "execution(* print.PrintingObject.*(..))" )
    private void logMethod() {
    }


    @Around( "logMethod()" )
    public Object doLog( ProceedingJoinPoint pjp ) throws Throwable {

        LOG.debug( "Method: " + pjp.getSignature().getName() + logparameter( pjp ) );

        return pjp.proceed();
    }


    private String logparameter( ProceedingJoinPoint pjp ) {
        StringBuffer sb = new StringBuffer();
        sb.append( "(" );
        for ( Object el : pjp.getArgs() ) {
            sb.append( el.toString() + "," );
        }
        sb.append( ")" );
        return sb.toString();
    }

}
